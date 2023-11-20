package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LikeDAO {
	// 공통 변수 선언
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";

	// 공통) 디비 연결하기(CP)
	private Connection getCon() throws Exception {
		Context initCTX = new InitialContext();
		DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/mvc");
		con = ds.getConnection();

		System.out.println("LDAO: DB 연결 성공");

		return con;
	}

	// 공통) 자원 해제
	private void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// likeCheck(LikeDTO ldto) - 유저 게시글 찜 상태 확인 메서드
	public int likeCheck(LikeDTO ldto) {
		int result = 0;
		
		try {
			con = getCon();
			
			// sql, pstmt
			sql = "select * from Likes where bno = ? and user_id = ?;";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, ldto.getBno());
			pstmt.setString(2, ldto.getUser_id());
			
			// sql 실행
			rs = pstmt.executeQuery();
			
			// 데이터 처리
			if(rs.next()) { // 유저의 해당 게시글에 찜 기록이 있으면 1 리턴
					result = 1;					
			} else { // 찜 기록이 없으면 0 리턴
					result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		System.out.println("LDAO: result: " + result);
		return result;
	} // likeCheck(LikeDTO ldto) 종료
	
	// likeAction(LikeDTO ldto) - ajax로 찜하기를 구현하는 메서드
	public int likeAction(LikeDTO ldto) { // 
		int result = 0;
		int num = likeCheck(ldto); // likeCheck로 사용자의 찜 여부 판단
		
		try {
			con = getCon();
			
			// sql, pstmt
			if(num == 0) { // 찜 기록이 없으면 데이터 insert 필요
				sql = "insert into Likes (bno, user_id, do_like) values (?, ?, 1)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ldto.getBno());
				pstmt.setString(2, ldto.getUser_id());
				
				System.out.println("입력 성공!");
				result = pstmt.executeUpdate();
				
				sql= "update Product set like_count = like_count+1 where bno = ?";
				pstmt = con.prepareStatement(sql);	
				pstmt.setInt(1, ldto.getBno());
				
				pstmt.executeUpdate();
			} else { // 찜 기록이 있으면 찜을 취소해야하므로 delete 필요
				sql = "delete from Likes where bno = ? and user_id = ?";
				pstmt = con.prepareStatement(sql);	
				pstmt.setInt(1, ldto.getBno());
				pstmt.setString(2, ldto.getUser_id());
				
				pstmt.executeUpdate();
				
				System.out.println("삭제 성공!");
				result = 0;
				
				sql= "update Product set like_count = like_count-1 where bno = ?";
				pstmt = con.prepareStatement(sql);	
				pstmt.setInt(1, ldto.getBno());
				
				pstmt.executeUpdate();
			}
			System.out.println("LDAO: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	} // likeAction(LikeDTO ldto) 종료
	
	
	// 마이페이지에서 내가 찜한 상품만 불러오는 메소드
	public ArrayList<LikeDTO> getlikeList(String user_id) {
		ArrayList<LikeDTO> likedtolist = new ArrayList<LikeDTO>();
		try {
			// 디비연결정보
			// 1. 드라이버 로드
			// 2. 디비 연결
			con = getCon();

			// 3. SQL 작성(sele&ct) & pstmt 객체
			sql = "select * from Likes where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id); // %검색어%
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			// 글정보 전부 가져오기
			while (rs.next()) {
				LikeDTO dto = new LikeDTO();

				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDo_like(rs.getInt("do_like"));
				

				// 글 하나의 정보를 배열의 한칸에 저장
				likedtolist.add(dto);

				System.out.println(" DAO : 내가 찜한 상품만 배열만들기성공! ");
				System.out.println(" DAO : " + likedtolist.size());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		return likedtolist;
	}	

}