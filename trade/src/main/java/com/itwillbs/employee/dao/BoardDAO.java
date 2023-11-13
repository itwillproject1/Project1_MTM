package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.MemberDTO;

public class BoardDAO extends DAO{

	public int insertBoard(BoardDTO bdto, MemberDTO mdto) {
		// insertBoard() : 관리자 전용 게시판 글 쓰기
		// 공지사항, 이벤트 등
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("emp_pw").equals(mdto.getEmp_pw())) {
					result = 1;
					// bno(Auto_increment)
					// emp_id, category, subject, content, image, uploadDate, readcount;
					sql = "insert into Board(emp_id, category, subject, content, image, uploadDate, readcount)"
							+ " values(?, ?, ?, ?, ?, now(), 0)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getEmp_id());
					if(bdto.getCategory().equals("notice")) pstmt.setInt(2, 1);
					else if(bdto.getCategory().equals("event")) pstmt.setInt(2, 2);
					pstmt.setString(3, bdto.getSubject());
					pstmt.setString(4, bdto.getContent());
					pstmt.setString(5, bdto.getImage());
					pstmt.executeUpdate();
				}
				else result = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}
	
	public int updateBoard(BoardDTO bdto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(mdto.getEmp_pw().equals(rs.getString(1))) {
					result = 1;
					sql = "update Board subject = ?, content = ?, image = ? where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bdto.getSubject());
					pstmt.setString(2, bdto.getContent());
					pstmt.setString(3, bdto.getImage());
					pstmt.setInt(4, bdto.getBno());
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
	
	public int deleteBoard(BoardDTO bdto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(mdto.getEmp_pw().equals(rs.getString(1))){
					result = 1;
					sql = "delete from Board where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, bdto.getBno());
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
	
	public ArrayList boardList(String pageCategory, int startRow, int pageSize) {
		ArrayList bList = null;
		BoardDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Board";
			if(pageCategory.equals("notice")) sql += " where category = 1";
			else if(pageCategory.equals("event")) sql += " where category = 2";
			sql += " order by bno desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			bList = new ArrayList();
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setCategory(rs.getString("category"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				bList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return bList;
	}
	
	public BoardDTO boardContent(int index) {
		BoardDTO dto = null;
		try {
			con = getCon();
			sql = "";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(index);
				dto.setCategory(rs.getString("category"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	}
	
	public int boardCount(String pageCategory) {
		int count = 0;
		try {
			con = getCon();
			sql = "select count(*) from Board";
			if(pageCategory.equals("notice")) {
				sql += " where category = 1 ";		
			}
			else if(pageCategory.equals("event")) {
				sql += " where category = 2 ";
			}
			sql += "order by bno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return count;
	}

	public ArrayList boardList(String pageCategory, String search, String searchKeyword, int startRow, int pageSize) {
		ArrayList bList = null;
		BoardDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Board";
			if(pageCategory.equals("notice")) sql += " where category = 1";
			else if(pageCategory.equals("event")) sql += " where category = 2";
			sql += "and " + search + " like '%" + searchKeyword + "%'";
			sql += " order by bno desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			bList = new ArrayList();
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setCategory(rs.getString("category"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				bList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return bList;
	}
}
