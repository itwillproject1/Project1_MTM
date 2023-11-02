package com.itwillbs.employee.user.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmployeeUserDAO {
	private Connection con = null;
	private ResultSet rs = null;
	private String sql = "";
	private PreparedStatement pstmt = null;
	
	// Connection 설정
	private Connection getCon() throws Exception{
		Context initCTX = new InitialContext();
		Context envCTX = (Context)initCTX.lookup("java:comp/env");
		DataSource ds = (DataSource)envCTX.lookup("jdbc/mvc");
		con = ds.getConnection();
		System.out.println("DAO : DB 연결 성공");
		System.out.println("DAO : " + con);
		return con;
	}// getCon();
	
	// 데이터베이스 닫기
	private void CloseDB() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // CloseDB();
	
	public ArrayList userList() {
		ArrayList list = null;
		EmployeeUserDTO dto = null;
		try {
			con = getCon();
			sql = "select * from USER_BO";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList();
				while(rs.next()) {
					dto = new EmployeeUserDTO();
					dto.setUser_id(rs.getString("use_id"));
					dto.setName(rs.getString("name"));
					dto.setNickname(rs.getString("nickname"));
					dto.setRegdate(rs.getTimestamp("regdate"));
					dto.setPoint(rs.getInt("point"));
					dto.setAgree(rs.getBoolean("agree"));
					dto.setEmail(rs.getString("email"));
					dto.setAddress(rs.getString("address"));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
}
