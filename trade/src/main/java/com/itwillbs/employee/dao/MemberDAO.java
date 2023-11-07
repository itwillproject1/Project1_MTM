package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.MemberDTO;

public class MemberDAO extends DAO{
	
	// loginEmployee() : 관리자 로그인
	public int loginEmployee(MemberDTO dto) {
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
	public MemberDTO loadProfile(String id) {
		MemberDTO result = null;
		try {
			con = getCon();
			sql = "select * from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberDTO();
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
		public int changeProfile(MemberDTO dto) {
			int result = -1;
			try {
				con = getCon();
				sql = "update from Employee where emp_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				CloseDB();
			}
			return result;
		} // changeProfile();

		// employeePasswordFind() : 관리자 비밀번호 찾기
		public int employePwFind(MemberDTO dto) {
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
		public int employeePwChange(MemberDTO dto, String newPw) {
			int result = -1;
			try {
				con = getCon();
				sql = "select emp_pw from Employees where emp_id = ?";
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
		
		// loadEmployeeList() : 직원 목록 return
		public ArrayList loadEmployeeList(int currentPage) {
			// 1페이지 8명
			int content = 8;
			ArrayList empList = null;
			try {
				con = getCon();
				sql = "select * from Employees order by join_date limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (currentPage-1) * content);
				pstmt.setInt(2, content);
				rs = pstmt.executeQuery();
				empList = new ArrayList();
				while(rs.next()) {
					MemberDTO dto = new MemberDTO();
					dto.setEmp_id(rs.getString("emp_id"));
					dto.setImage(rs.getString("image"));
					dto.setName(rs.getString("name"));
					dto.setTel(rs.getString("tel"));
					dto.setJoin_date(rs.getDate("join_date"));
					dto.setEmail(rs.getString("email"));
					empList.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				CloseDB();
			}
			return empList;
		} // loadEemployeeList();
		
		// employeeCount() : 직원 수 return
		public int employeeCount() {
			int result = 0;
			try {
				con = getCon();
				sql = "select count(*) from Employee";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				CloseDB();
			}
			return result;
		} // employeeCount();
			
}
