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
			sql = "select emp_pw from Employee where emp_id = ?";
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
					pstmt.setString(2, bdto.getCategory());
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
			sql = "select emp_pw from Employee where emp_id = ?";
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
			sql = "select emp_pw from Employee where emp_id = ?";
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
	
	public ArrayList boardList(int currentPage) {
		ArrayList bList = null;
		BoardDTO dto = null;
		int columns = 8;
		try {
			con = getCon();
			sql = "select * from Board limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (currentPage - 1) * columns);
			pstmt.setInt(2, columns);
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
	
	public int boardCount() {
		int count = 0;
		try {
			con = getCon();
			sql = "select count(*) from Board";
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
	
}
