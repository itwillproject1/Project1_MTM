package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itwillbs.product.db.TradeHistoryDTO;

public class TradeHistoryDAO {
	
	
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
		
	// 거래 기록 저장
		public void tradehistory (TradeHistoryDTO dto) {
			try {
				con = getCon();
				
				sql = "insert into TradeHistory (user_id, deal_way, bno, trader_id, price, address ,tradeDate) values(?,?,?,?,?,?,now())";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, dto.getUser_id());
				pstmt.setString(2, dto.getDeal_way());	//삽니다. 팝니다.
				pstmt.setInt(3, dto.getBno());
				pstmt.setString(4, dto.getTrader_id());
				pstmt.setInt(5, dto.getPrice());
				pstmt.setString(6, dto.getAddress());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
		}
		
		
}	