package com.itwillbs.employee.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmployeeMemberDAO {
	private Connection con = null;
	private ResultSet rs = null;
	private String sql = "";
	private PreparedStatement pstmt = null;
	
	// Connection 설정
	private Connection getCon() throws Exception{
		Context initCTX = new InitialContext();
		Context envCTX = (Context)initCTX.lookup("java:comp/env");
		DataSource ds = (DataSource)envCTX.lookup("jdbc/c7d2307t1");
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
	
	// loginEmployee() : 관리자 로그인
	public int loginEmployee(EmployeeMemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("emp_pw").equals(dto.getEmp_pw())) {
					result = 1;
				}
				else result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // loginEmployee();
	
	
	// loadProfile() : 관리자 프로필 불러오기
	public EmployeeMemberDTO loadProfile(String id) {
		EmployeeMemberDTO result = null;
		try {
			con = getCon();
			sql = "select * from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new EmployeeMemberDTO();
				result.setEmp_id(rs.getString("emp_id"));
				result.setEmp_pw(rs.getString("emp_pw"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setAddress(rs.getString("address"));
				result.setTel(rs.getString("tel"));
				result.setJoin_date(rs.getDate("join_date"));
				result.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // loadProfile();
	
	
	// changeProfile() : 관리자 프로필 편집
	public int changeProfile(EmployeeMemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // changeProfile();
	
	// loadEmployeeList() : 관리자 리스트 출력(admin 전용)
	public ArrayList loadEmployeeList (int startPage, int page) {
		ArrayList dtoList = null;
		try {
			con = getCon();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dtoList;
	} // loadEmployeeList();
	
	// employeePasswordFind() : 관리자 비밀번호 찾기
	public int employePwFind(EmployeeMemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select email from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(0).equals(dto.getEmp_id())) {
					result = 1;
				}
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // employeePasswordFind();
	
	// employeePwChange() : 관리자 비밀번호 변경
	public int employeePwChange(EmployeeMemberDTO dto, String newPw) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(0).equals(dto.getEmp_pw())) {
					result = 1;
					sql = "update from Employees ";
					pstmt = con.prepareStatement(sql);
				}
				result = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // employeePwChange();
}
