package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.UserDTO;

public class InquiryDAO extends DAO {

	// updateInquiry() : 문의 답변
	public void updateInquiry(InquiryDTO dto) {
		try {
			con = getCon();
			// 답변 정보 입력
			sql = "update Inquiry set complete = 1, emp_id = ?, answerContent = ?, answerDate = now() where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			pstmt.setString(2, dto.getAnswerContent());
			pstmt.setInt(3, dto.getBno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
	}

	// deleteInquiry() : 문의 삭제
	public int deleteInquiry(InquiryDTO dto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employee where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (mdto.getEmp_pw().equals(rs.getString(1))) {
					result = 1;
					sql = "delete from Inquiry where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, dto.getBno());
					pstmt.executeUpdate();
				} else
					result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}

	// inquiryList() : 문의 목록 표시, 검색 & 페이징 기능 포함
	public ArrayList inquiryList(String pageCategory, String search, String searchKeyword, String category,
			int startRow, int pageSize) {
		ArrayList list = null;
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Inquiry where ";
			// 전체/완료/미처리
			if (pageCategory.equals("all"))
				sql += "user_id = user_id ";
			else if (pageCategory.equals("0"))
				sql += " complete = 0";
			else if (pageCategory.equals("1"))
				sql += " complete = 1";
			
			// 검색 / 카테고리
			// null Check
			if (search == null || searchKeyword == null)
				;
			else if (search != null && searchKeyword != null) {
				sql += " and " + search + " like '%" + searchKeyword + "%'";
			}
			// null Check
			if (category == null)
				;
			else if (category != null) {
				sql += " and category = " + category;
			}
			// 페이징 처리
			sql += " order by bno desc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setCategory(rs.getString("category"));
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
	} // inquiryList()

	// inquiryContent() : 문의 상세 정보
	public InquiryDTO inquiryContent(int index) {
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Inquiry where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setCategory(rs.getString("category"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setImage(rs.getString("image"));
				System.out.println(dto.getImage());
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setAnswerContent(rs.getString("answerContent"));
				dto.setAnswerDate(rs.getTimestamp("answerDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	} // inquiryContent()

	
	// inquiryCount() : 문의 개수
	public int inquiryCount() {
		int count = 0;
		try {
			con = getCon();
			sql = "select count(*) from Inquiry";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return count;
	} // inquiryCount()

	// inquiryCount() : 문의 개수(카테고리)
	public int inquiryCount(boolean complete) {
		int count = 0;
		try {
			con = getCon();
			if (complete) {
				sql = "select count(*) from Inquiry where complete = 1";
			} else {
				sql = "select count(*) from Inquiry where complete = 0";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return count;
	}// inquiryCount()

	// userInfoInquiry() : 유저 상세 정보에 호출될 문의 목록
	public ArrayList userInfoInquiry(UserDTO udto) {
		ArrayList list = null;
		InquiryDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Inquiry where user_id = ? order by bno desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, udto.getUser_id());
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				dto = new InquiryDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setCategory(rs.getString("category"));
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
	} // userInfoInquiry()
}
