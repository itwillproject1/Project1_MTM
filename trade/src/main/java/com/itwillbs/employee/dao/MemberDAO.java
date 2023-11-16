package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.MemberDTO;

public class MemberDAO extends DAO{
	
	// loginEmployee() : 관리자 로그인
	public int loginEmployee(MemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ? and active = 1";
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
				result.setActive(rs.getInt("active"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // loadProfile();
		
		
		// changeProfile() : 관리자 프로필 편집
		public int changeProfile(MemberDTO dto, String new_pw, String confirm_pw) {
			int result = -1;
			try {
				con = getCon();
				sql = "select emp_pw from Employees where emp_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getEmp_id());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).equals(dto.getEmp_pw())) {
						if(new_pw == null || confirm_pw == null || new_pw.equals("") || confirm_pw.equals("")) {
							sql = "update Employees set name = ?, address = ?, email = ?, tel = ? where emp_id = ?";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, dto.getName());
							pstmt.setString(2, dto.getAddress());
							pstmt.setString(3, dto.getEmail());
							pstmt.setString(4, dto.getTel());
							pstmt.setString(5, dto.getEmp_id());
							pstmt.executeUpdate();
							result = 1;
						}
						else {
							if(new_pw.equals(confirm_pw)) {
								sql = "update Employees set name = ?, address = ?, email = ?, tel = ?, "
										+ "emp_pw = ? where emp_id = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, dto.getName());
								pstmt.setString(2, dto.getAddress());
								pstmt.setString(3, dto.getEmail());
								pstmt.setString(4, dto.getTel());
								pstmt.setString(5, new_pw);
								pstmt.setString(6, dto.getEmp_id());
								pstmt.executeUpdate();
								result = 1;
							}
						}
					}
					else {
						result = 0;
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				CloseDB();
			}
			return result;
		} // changeProfile();

		// employeeCount() : 직원 수 return
		public int employeeCount() {
			int result = 0;
			try {
				con = getCon();
				sql = "select count(*) from Employees";
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
		
		public ArrayList employeeList(int startRow, int pageNum) {
			ArrayList list = null;
			MemberDTO dto = null;
			try {
				con = getCon();
				sql = "select * from Employees order by emp_id limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, pageNum);
				rs = pstmt.executeQuery();
				list = new ArrayList();
				while(rs.next()) {
					dto = new MemberDTO();
					dto.setEmp_id(rs.getString("emp_id"));
					dto.setEmp_pw(rs.getString("emp_pw"));
					dto.setName(rs.getString("name"));
					dto.setEmail(rs.getString("email"));
					dto.setAddress(rs.getString("address"));
					dto.setTel(rs.getString("tel"));
					dto.setJoin_date(rs.getDate("join_date"));
					dto.setActive(rs.getInt("active"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				CloseDB();
			}
			return list;
		}

		public void employeeRegister(MemberDTO dto) {
			try {
				con = getCon();
				sql = "insert into Employees (emp_id, emp_pw, name, email, tel, address, join_date) values(?,?,?,?,?,?,now())";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getEmp_id());
				pstmt.setString(2, dto.getEmp_pw());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getEmail());
				pstmt.setString(5, dto.getTel());
				pstmt.setString(6, dto.getAddress());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				CloseDB();
			}
		}
	
	public int resetPw(MemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select email from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(dto.getEmail().equals(rs.getString(1))) {
					result = 1;
					sql = "select tel from Employees where emp_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getEmp_id());
					rs = pstmt.executeQuery();
					if(rs.next()) dto.setTel(rs.getString("tel"));
					String pw = dto.getTel().substring(dto.getTel().length() - 4);
					sql = "update Employees set emp_pw = ? where emp_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, pw);
					pstmt.setString(2, dto.getEmp_id());
					pstmt.executeUpdate();
				}
				else result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}
	
	public int employeeInactive(MemberDTO emp, MemberDTO ad) {
		// employeeInactive() : 직원 비활성화
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ad.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(ad.getEmp_pw())) {
					result = 1;
					sql = "update Employees set active = 0 where emp_id = ?";
					pstmt =  con.prepareStatement(sql);
					pstmt.setString(1, emp.getEmp_id());
					pstmt.executeUpdate();
				}
				else result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}

	public int employeeActive(MemberDTO emp, MemberDTO ad) {
		// employeeActive() : 직원 활성화
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ad.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(ad.getEmp_pw())) {
					result = 1;
					sql = "update Employees set active = 1 where emp_id = ?";
					pstmt =  con.prepareStatement(sql);
					pstmt.setString(1, emp.getEmp_id());
					pstmt.executeUpdate();
				}
				else result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}
}
