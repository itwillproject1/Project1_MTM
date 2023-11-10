package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.employee.dto.MemberDTO;

public class InquiryDAO extends DAO{

	public int updateInquiry(InquiryDTO idto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employee where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(mdto.getEmp_pw().equals(rs.getString(1))) {
					result = 1;
					sql = "update from Inquiry set complete = 1, emp_id = ?, answerContent = ? answerDate = now() where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getEmp_id());
					pstmt.setString(2, idto.getAnswerContent());
					pstmt.setInt(3, idto.getBno());
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
	
	public int deleteInquiry(InquiryDTO dto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employee where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(mdto.getEmp_pw().equals(rs.getString(1))){
					result = 1;
					sql = "delete from Inquiry where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, dto.getBno());
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
	
	public ArrayList inquiryList(String pageCategory, String search, String searchKeyword, String category, int startRow, int pageSize) {
		ArrayList list = null;
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Inquiry where ";
			if(pageCategory.equals("all")) sql += "user_id = user_id ";
			else if(pageCategory.equals("0")) sql += " complete = 0";
			else if(pageCategory.equals("1")) sql += " complete = 1";
			
			if(search == null || searchKeyword == null);
			else if(search != null && searchKeyword!= null) {
				sql += " and " + search + " like '%" + searchKeyword + "%'";
			}
			if(category == null);
			else if(category != null) {
				sql += " and category = " + category;
			}
			sql += " order by bno desc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setCategory(rs.getInt("category"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setAnswerContent(rs.getString("answerContent"));
				dto.setAnswerDate(rs.getTimestamp("answerDate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public InquiryDTO inquiryContent(int index) {
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Inquiry where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setCategory(rs.getInt("category"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setAnswerContent(rs.getString("answerContent"));
				dto.setAnswerDate(rs.getTimestamp("answerDate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	}
	
	public int inquiryCount() {
		int count = 0;
		try {
			con = getCon();
			sql = "select count(*) from Inquiry";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return count;
	}
	
	public int inquiryCount(boolean complete) {
		int count = 0;
		try {
			con = getCon();
			if(complete) {
				sql = "select count(*) from Inquiry where complete = 1";
			}
			else {
				sql = "select count(*) from Inquiry where complete = 0";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return count;
	}
}
