package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SuggestSellDAO {
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

		System.out.println("SSDAO: DB 연결 성공");

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

	// 거래 제안 메서드 
	public int suggestSell(SuggestSellDTO ssdto) {
		int bno = ssdto.getBuy_bno();
		try {
			con = getCon();

			sql = "insert into SuggestSell (buy_bno, sell_bno, buyer_user_id, seller_user_id, buyer_price, seller_price) values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, ssdto.getBuy_bno());
			pstmt.setInt(2, ssdto.getSell_bno());
			pstmt.setString(3, ssdto.getBuyer_user_id());
			pstmt.setString(4, ssdto.getSeller_user_id());
			pstmt.setInt(5, ssdto.getBuyer_price());
			pstmt.setInt(6, ssdto.getSeller_price());

			// sql 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return bno;
	} // uploadProduct() 종료
}