package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.UserDTO;

public class UserDAO extends DAO{
	public int userPaySum() {
		int result = 0;
		try {
			con = getCon();
			sql = "select sum(pay) from Member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}

	public ArrayList userList(String pageCategory, 
			String search, String searchKeyword, 
			int startRow, int pageSize) {
		ArrayList list = null;
		UserDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member where address = address";
			if(pageCategory.equals("agree")) {
				sql += " and agree = '동의' ";
			}
			else if(pageCategory.equals("notAgree")) {
				sql += " and agree = '비동의' ";
			}
			else if(pageCategory.equals("suspended")) {
				sql += " and suspended = 1 ";
			}
			
			if(search == null || searchKeyword == null);
			else sql += "and " + search + " like '%" + searchKeyword + "%'";
			sql += " limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				dto = new UserDTO();
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_nickname(rs.getString("user_nickname"));
				dto.setPhone(rs.getString("phone"));
				//dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setPay(rs.getInt("pay"));
				dto.setAgree(rs.getString("agree"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public int userCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int userCount(String pageCategory, String search, String searchKeyword) {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Member where address = address";
			if(pageCategory.equals("agree")) {
				sql += " and agree = '동의'";
			}
			else if(pageCategory.equals("notAgree")) {
				sql += " and agree = '비동의'";
			}
			else if(pageCategory.equals("suspended")) {
				sql += " and suspended = 1";
			}
			
			if(search == null || searchKeyword == null);
			else sql += search + "like '%" + searchKeyword + "%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}
	
	public UserDTO userInfo(String user_id) {
		// userContent(String user_id) : 유저 정보 조회
		UserDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUser_id(user_id);
				dto.setUser_nickname(rs.getString("user_nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setAddress(rs.getString("address"));
				dto.setJumin(rs.getString("jumin"));
				dto.setProfile(rs.getString("profile"));
				dto.setPay(rs.getInt("pay"));
				dto.setAgree(rs.getString("agree"));
				if(rs.getInt("suspended") == 1) dto.setSuspended(true);
				else dto.setSuspended(false);
				dto.setSus_days(rs.getInt("sus_days"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	} // userContent();
	
	
}
