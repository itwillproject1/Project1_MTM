package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.employee.dto.MemberDTO;

public class ComplainDAO extends DAO{

	public int updateComplain(ComplainDTO idto, MemberDTO mdto) {
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
					sql = "update Complain set emp_id = ?,"
							+ " completeDate = now(), complainResult = ?, resultDays = ? "
							+ "where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getEmp_id());
					pstmt.setString(2, idto.getComplainResult());
					pstmt.setInt(3, idto.getResultDays());
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
	
	public int deleteComplain(ComplainDTO cdto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employee where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(mdto.getEmp_pw().equals(rs.getString(1))){
					result = 1;
					sql = "delete from Complain where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, cdto.getBno());
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
	
	public ArrayList complainList(int currentPage) {
		ArrayList cList = null;
		ComplainDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (currentPage - 1) * 8);
			pstmt.setInt(2, 8);
			rs = pstmt.executeQuery();
			cList = new ArrayList();
			while(rs.next()) {
				dto = new ComplainDTO();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return cList;
	}
	
	public ComplainDTO complainContent(int index) {
		ComplainDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ComplainDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setComplainer_id(rs.getString("complainer_id"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setComplainReason(rs.getString("complainReason"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setComplainResult(rs.getString("complainResult"));
				dto.setResultDays(rs.getInt("resultDays"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	}
	
	public int complainCount() {
		int count = 0;
		try {
			con = getCon();
			sql = "select count(*) from Complain";
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
	
	public ArrayList complainSearch(String category, String keyword) {
		ArrayList cList = null;
		ComplainDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain where ? = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			cList = new ArrayList();
			while(rs.next()) {
				dto = new ComplainDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setComplainer_id(rs.getString("complainer_id"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setComplainReason(rs.getString("complainReason"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setComplete(rs.getBoolean("complete"));
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setComplainResult(rs.getString("complainResult"));
				dto.setResultDays(rs.getInt("resultDays"));
				cList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return cList;
	}
}
