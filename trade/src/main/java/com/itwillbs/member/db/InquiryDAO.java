package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.itwillbs.product.db.ProductDTO;

public class InquiryDAO {
		// 공통 변수 선언
		private Connection con = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		private String sql = "";
		
		// 공통) 디비 연결하기
		private Connection getCon() throws Exception {
			Context initCTX = new InitialContext();
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/mvc");
			con = ds.getConnection();
			
	//		System.out.println("DAO: DB 연결 성공");
	//		System.out.println("DAO: " + con);
			
			return con;
		}
		
		// 공통) 자원 해제
		private void closeDB() {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
		// 문의글 등록 메서드(uploadQna)
		public int uploadQna(InquiryDTO idto) {
			int bno = 0;
			try {
				con = getCon();

				// sql, pstmt
				sql = "select max(bno) from Inquiry";
				pstmt = con.prepareStatement(sql);

				// sql 쿼리 실행
				rs = pstmt.executeQuery();

				// 데이터 처리(글번호 계산)
				if (rs.next()) {
					bno = rs.getInt(1) + 1;
				}

	//			System.out.println("IDAO: 글번호: " + bno);

				// sql, pstmt
				sql = "insert into Inquiry (bno, user_id, subject, category, content, image, uploadDate)"
						+ " values (?,?,?,?,?,?,now())";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, bno);
				pstmt.setString(2, idto.getUser_id());
				pstmt.setString(3, idto.getSubject());
				pstmt.setString(4, idto.getCategory());
				pstmt.setString(5, idto.getContent());
				pstmt.setString(6, idto.getImage());

				
				// sql 실행
				pstmt.executeUpdate();
				
				idto.setBno(bno);
	//			System.out.println("DAO: " + bno + "번 글 작성 완료");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return bno;
		} // uploadQna() 종료
		
		// 특정 번호에 해당하는 글 정보를 가져오는 getQna(int bno) 메서드
		public InquiryDTO getQna(int bno) {
			InquiryDTO idto = null;

			try {
				con = getCon();

				// sql, pstmt
				sql = "select * from Inquiry where bno = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, bno);

				// sql 실행
				rs = pstmt.executeQuery();

				// 데이터 처리
				if (rs.next()) {
					idto = new InquiryDTO(); // 데이터가 있을 때 객체를 생성(메모리 활용을 위해)

					idto.setUser_id(rs.getString("user_id"));
					idto.setSubject(rs.getString("subject"));
					idto.setCategory(rs.getString("category"));
					idto.setContent(rs.getString("content"));
					idto.setImage(rs.getString("image"));
					idto.setUploadDate(rs.getTimestamp("uploadDate"));
					idto.setComplete(rs.getBoolean("complete"));
					idto.setEmp_id(rs.getString("emp_id"));
					idto.setAnswerContent(rs.getString("answerContent"));
					idto.setAnswerDate(rs.getTimestamp("answerDate"));
				}
	//			System.out.println("DAO: 글 정보 조회 완료!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}

			return idto;
		} // getProduct(int bno) 종료
		
		// 글 개수 계산 메서드 - getQnaCount()
		public int getQnaCount(String user_id) {
			int result = 0;

			try {
				con = getCon();
				// 3. sql 작성(select) & pstmt 객체
				sql = "select count(*) from Inquiry where user_id = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user_id);

				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터 처리 - 개수를 저장
				if (rs.next()) {
					result = rs.getInt(1);
				}
	//			System.out.println(" DAO : 개수 " + result + "개");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}

			return result;
		}
		
		// 글 정보 목록을 가져오는 메서드 - getQnaList(int startRow,int pageSize)
		public ArrayList getQnaList(int startRow, int pageSize, String user_id) {
			// 글정보를 저장하는 배열
			ArrayList QnaList = new ArrayList();
			try {
				// 디비연결정보
				// 1. 드라이버 로드
				// 2. 디비 연결
				con = getCon();
				// 3. SQL 작성(select) & pstmt 객체
				sql = "select * from Inquiry where user_id = ? order by bno limit ?,?";
				pstmt = con.prepareStatement(sql);
				// ????
				pstmt.setString(1, user_id);
				pstmt.setInt(2, startRow - 1); // 시작행번호-1
				pstmt.setInt(3, pageSize); // 개수
				
				// 4. SQL 실행
				rs = pstmt.executeQuery();
				// 5. 데이터 처리
				// 글정보 전부 가져오기
				while (rs.next()) {
					InquiryDTO idto = new InquiryDTO(); // 데이터가 있을 때 객체를 생성(메모리 활용을 위해)

					idto.setBno(rs.getInt("bno"));
					idto.setUser_id(rs.getString("user_id"));
					idto.setSubject(rs.getString("subject"));
					idto.setCategory(rs.getString("category"));
					idto.setContent(rs.getString("content"));
					idto.setImage(rs.getString("image"));
					idto.setUploadDate(rs.getTimestamp("uploadDate"));
					idto.setComplete(rs.getBoolean("complete"));
					idto.setEmp_id(rs.getString("emp_id"));
					idto.setAnswerContent(rs.getString("answerContent"));
					idto.setAnswerDate(rs.getTimestamp("answerDate"));

					// 글 하나의 정보를 배열의 한칸에 저장
					QnaList.add(idto);

				} // while

		//		System.out.println(" DAO : 글 목록 조회성공! ");
		//		System.out.println(" DAO : " + QnaList.size());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return QnaList;
		}
		
		}
