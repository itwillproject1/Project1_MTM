package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
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
			
			System.out.println("DAO: DB 연결 성공");
			
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
		
		// 글 작성 메서드(uploadProduct)
		public int uploadProduct(ProductDTO dto) {
			int bno = 0;
			try {
				getCon();
				
				// sql, pstmt
				sql = "select max(bno) from Product";
				pstmt = con.prepareStatement(sql);
				
				// sql 쿼리 실행
				rs = pstmt.executeQuery();
				
				// 데이터 처리(글번호 계산)
				if(rs.next()) {
					bno = rs.getInt(1) + 1;
				}
				
				System.out.println("DAO: 글번호: " + bno);
				
				// sql, pstmt
				sql = "insert into Product (bno, user_id, deal_way, title, category, brand, "
						+ "price, product_status, content, views, date_time, file_name) values (?,?,?,?,?,?,?,?,?,?,now(),?)";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, bno);
	            pstmt.setString(2, dto.getUser_id());
	            pstmt.setString(3, dto.getDeal_way());
	            pstmt.setString(4, dto.getTitle());
	            pstmt.setString(5, dto.getCategory());
	            
	            pstmt.setString(6, dto.getBrand()); 
	            pstmt.setInt(7, dto.getPrice()); 
	            pstmt.setString(8, dto.getProduct_status()); 
	            pstmt.setString(9, dto.getContent());
	            pstmt.setInt(10, 0); // 조회수 0
	            pstmt.setString(11, dto.getFile_name());

				// sql 실행
				pstmt.executeUpdate();
				dto.setBno(bno);
				System.out.println("DAO: " + bno + "번 글 작성 완료");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return bno;
		} // uploadProduct() 종료
		
		// 조회수를 1 증가시키는 updateReadcount()
		public void updateReadcount(int bno) {
			try {
				// 1. 디비 연결
				con = getCon();

				// 2. sql 작성, pstmt 객체
				sql = "update Product set views=views+1 where bno=?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, bno);

				// 3. sql 실행
				pstmt.executeUpdate();

				System.out.println("DAO: 게시판 조회수 1 증가 완료!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
		} // updateReadcount() 종료
		
		// 특정 번호에 해당하는 글 정보를 가져오는 getProduct(int bno) 메서드
		public ProductDTO getProduct(int bno) {
			ProductDTO dto = null;

			try {
				con = getCon();

				// sql, pstmt
				sql = "select * from Product where bno = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, bno);

				// sql 실행
				rs = pstmt.executeQuery();

				// 데이터 처리
				if (rs.next()) {
					dto = new ProductDTO(); // 데이터가 있을 때 객체를 생성(메모리 활용을 위해)

					dto.setBno(rs.getInt("bno"));
					dto.setContent(rs.getString("content"));
					dto.setUser_id(rs.getString("user_id"));
					dto.setDeal_way(rs.getString("deal_way"));
					dto.setTitle(rs.getString("title"));
					dto.setCategory(rs.getString("category"));
					dto.setBrand(rs.getString("brand"));
					dto.setPrice(rs.getInt("price"));
					dto.setProduct_status(rs.getString("product_status"));
					dto.setContent(rs.getString("content"));
					dto.setViews(rs.getInt("views"));
					dto.setDate_time(rs.getTimestamp("date_time"));
					dto.setFile_name(rs.getString("file_name"));
				}
				System.out.println("DAO: 글 정보 조회 완료!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}

			return dto;
		} // getProduct(int bno) 종료

		
		// 사용자 아이디에 해당하는 상품 정보(상품명, 상품상태, 가격) 가져오는 ProductInfo(user_id) 메서드
		public ProductDTO ProductInfo(String user_id) {
			ProductDTO dto = null;
			 try {
				 con = getCon();
				// sql, pstmt
				 sql = "select * from Product where user_id=?";
				 pstmt = con.prepareStatement(sql);
				 pstmt.setString(1, user_id);
				// sql 실행
				rs = pstmt.executeQuery();
				
				// 데이터 처리
				if (rs.next()) {
					dto = new ProductDTO();
					dto.setFile_name(rs.getString("file_name"));
					dto.setTitle(rs.getString("title"));
					dto.setProduct_status(rs.getString("product_status"));
					dto.setPrice(rs.getInt("price"));
				}
			 } catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
			 return dto;
		} // ProductInfo(user_id) 종료
		
}
