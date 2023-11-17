package com.itwillbs.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.employee.dto.UserDTO;

public class DAO {
	// DAO 분리, 하지만 데이터베이스 작업은 하나로만 진행
	// update, delete, insert, select, search 등
	protected Connection con = null;
	protected ResultSet rs = null;
	protected String sql = "";
	protected PreparedStatement pstmt = null;

	// Connection 설정
	protected Connection getCon() throws Exception {
		Context initCTX = new InitialContext();
		Context envCTX = (Context) initCTX.lookup("java:comp/env");
		DataSource ds = (DataSource) envCTX.lookup("jdbc/mvc");
		con = ds.getConnection();
		System.out.println("DAO : DB 연결 성공");
		System.out.println("DAO : " + con);
		return con;
	}// getCon();

	// 데이터베이스 닫기
	protected void CloseDB() {
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
	} // CloseDB();
}
