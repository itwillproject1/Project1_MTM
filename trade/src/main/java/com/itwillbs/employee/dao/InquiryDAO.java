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
					sql = "update ";
					pstmt = con.prepareStatement(sql);
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
	
	public ArrayList inquiryList(int currentPage) {
		ArrayList iList = null;
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Inquiry";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			iList = new ArrayList();
			while(rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setAnswerContent(rs.getString("answerContent"));
				dto.setAnswerDate(rs.getTimestamp("answerDate"));
				iList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return iList;
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
	
	public ArrayList inquirySearch(String category, String keyword) {
		ArrayList iList = null;
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain where ? = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			iList = new ArrayList();
			while(rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setAnswerContent(rs.getString("answerContent"));
				dto.setAnswerDate(rs.getTimestamp("answerDate"));
				iList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return iList;
	}
	
}
