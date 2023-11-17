package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.MailDTO;

public class MailDAO extends DAO {
	public int sendMailCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Mail";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}
	
	public int sendMailCount(String search, String searchKeyword) {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Mail where ";
			sql += search + " like '%" + searchKeyword + "%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}

	public ArrayList mailList(int startRow, int pageSize) {
		ArrayList list = null;
		MailDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Mail limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				dto = new MailDTO();
				dto.setIdx(rs.getInt(1));
				dto.setEmp_id(rs.getString(2));
				dto.setSubject(rs.getString(3));
				dto.setContent(rs.getString(4));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public ArrayList mailList(String search, String searchKeyword, int startRow, int pageSize) {
		ArrayList list = null;
		MailDTO dto = null;
		try {
			con = getCon();
			sql = "selece * from Mail";
			sql += "where " + search + " like '%" + searchKeyword + "%'";
			sql += " limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				dto = new MailDTO();
				dto.setIdx(rs.getInt(1));
				dto.setEmp_id(rs.getString(2));
				dto.setSubject(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setSendDate(rs.getTimestamp(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}

	public MailDTO mailContent(int idx) {
		MailDTO dto = null;
		try {
			con = getCon();
			sql = "selece * from Mail where idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MailDTO();
				dto.setIdx(rs.getInt(1));
				dto.setEmp_id(rs.getString(2));
				dto.setSubject(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setImage(rs.getString(5));
				dto.setSendDate(rs.getTimestamp(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	}

	public void mailInsert(MailDTO dto) {
		try {
			con = getCon();
			sql = "";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
	}
}
