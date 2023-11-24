package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.MailDTO;

public class MailDAO extends DAO {
	// sendMailCount() : 전송완료된 메일 개수
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
	}// sendMailCount()
	
	// sendMailCount() : 전송완료된 메일 개수, 검색 포함
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
	}// sendMailCount()

	// mailList() : 메일 목록, 페이징 처리
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
	} // mailList()
	
	// mailList() : 메일 목록, 페이징 처리, 검색 기능
	public ArrayList mailList(String search, String searchKeyword, int startRow, int pageSize) {
		ArrayList list = null;
		MailDTO dto = null;
		try {
			con = getCon();
			sql = "selece * from Mail";
			// 검색
			sql += "where " + search + " like '%" + searchKeyword + "%'";
			// 페이징 처리
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
	}// mailList()

	// mailContent() : 메일 상세 정보
	public MailDTO mailContent(int idx) {
		MailDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Mail where idx = ?";
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
	}// mailContent()

	// mailInsert() : 전송된 메일 추가
	public void mailInsert(MailDTO dto) {
		try {
			con = getCon();
			sql = "insert into Mail (emp_id, subject, content, image, sendDate) values(?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getImage());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
	}// mailInsert()
}
