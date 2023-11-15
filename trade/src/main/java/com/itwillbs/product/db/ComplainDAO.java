package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class ComplainDAO {
	
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

			System.out.println("CDAO: DB 연결 성공");

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
		
	// 신고하기 메서드 - addComplain(int bno)
			public ComplainDTO addComplain(ComplainDTO cdto) {
				try {
					con = getCon();
					// sql, pstmt
					sql = "INSERT INTO Complain(bno, complainer_id, user_id, complainReason,"
							+ " uploadDate, emp_id, completeDate) VALUES (?,?,?,?,NOW(),?,?)";
			        pstmt = con.prepareStatement(sql);
			        
			        pstmt.setInt(1, cdto.getBno());
			        pstmt.setString(2, cdto.getComplainer_id());
			        pstmt.setString(3, cdto.getUser_id());
			        pstmt.setString(4, cdto.getComplainReason());
			        pstmt.setString(5, cdto.getEmp_id());
			        pstmt.setTimestamp(6, cdto.getCompleteDate());
			        
					// sql 실행
			        pstmt.executeUpdate();
					System.out.println("CDAO: 신고 정보 전송 완료!");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeDB();
				}
				return cdto;
			} // 신고하기 메서드 종료
}
