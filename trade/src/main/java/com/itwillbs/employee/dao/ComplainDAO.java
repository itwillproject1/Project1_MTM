package com.itwillbs.employee.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.SuspendDTO;
import com.itwillbs.employee.dto.UserDTO;

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
	
	public int complainCount(boolean complete) {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Complain";
			if(complete) sql += " where complete = 1";
			else sql += " where complete = 0";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int complainUserCount() {
		int result = 0;
		try {
			con =  getCon();
			sql = "select * from Member where suspended = 1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList complainList(int startRow, int pageSize) {
		ArrayList list = null;
		ComplainDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain";
			sql += " where complete = 0";
			sql += " order by bno desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ComplainDTO();
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			CloseDB();
		}
		return list;
	}

	public ArrayList suspendedList(int startRow, int pageSize) {
		ArrayList list = null;
		MemberDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member where suspended = 1 limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDTO();
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}

	public ArrayList userInfoComplain(UserDTO udto) {
		// userInfoComplain() : 유저 정보에 표시 될 신고처리 미완료된 목록
		ArrayList list = null;
		HashSet<String> set = new HashSet<String>();	// 중복 확인
		ComplainDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain where user_id = ? order by bno desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, udto.getUser_id());
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				// 신고처리가 되지 않은 목록 중 중복된 신고 제거
				if(set.contains(rs.getString("complainer_id"))) continue;
				dto = new ComplainDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setBno(rs.getInt("bno"));
				dto.setComplainer_id(rs.getString("complainer_id"));
				dto.setComplainReason(rs.getString("complainReason"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				set.add(dto.getComplainer_id());
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public ArrayList<SuspendDTO> complainedUserList(int startRow, int pageSize) {
		// complainedUserList() : 피신고자 목록(정지x)
		HashSet<String> set = new HashSet<String>();	// 중복 확인
		ArrayList<SuspendDTO> list = null;
		ComplainDTO cdto = null;
		SuspendDTO sdto = null;
		try {
			con = getCon();
			sql = "select user_id from Complain where complete = false group by user_id limit ?, ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			list = new ArrayList<SuspendDTO>();
			while(rs.next()) {
				sdto = new SuspendDTO();
				sdto.setuser_id(rs.getString(1));
				list.add(sdto);
			}
			
			LinkedList<ComplainDTO> dtoList = null;
			for(int i = 0; i<list.size(); i++) {
				dtoList = new LinkedList<ComplainDTO>();
				sdto = list.get(i);
				sql = "select * from Complain where complete = false and user_id = ? order by uploadDate";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sdto.getuser_id());
				rs = pstmt.executeQuery();
				int count = 0;
				while(rs.next()) {
					if (count == 0) {
						sdto.setFirstComplainedDate(rs.getTimestamp("uploadDate"));
					}
					// 신고처리가 되지 않은 목록 중 중복된 신고 제거
					if(set.contains(rs.getString("complainer_id"))) continue;
					cdto = new ComplainDTO();
					cdto.setIdx(rs.getInt("idx"));
					cdto.setBno(rs.getInt("bno"));
					cdto.setComplainer_id(rs.getString("complainer_id"));
					cdto.setComplainReason(rs.getString("complainReason"));
					cdto.setUploadDate(rs.getTimestamp("uploadDate"));
					count++;
					set.add(cdto.getComplainer_id());
					dtoList.add(cdto);
				}
				sdto.setCount(count);
				sdto.setReportList(dtoList);
				list.set(i, sdto);
				set.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public int complainedUserCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(distinct user_id) from Complain where complete = false";
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
	
	public boolean isSuspended(UserDTO dto) {
		boolean isSuspended = false;
		try {
			con = getCon();
			sql = "select suspended from Member where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			rs =  pstmt.executeQuery();
			if(rs.next()) isSuspended = rs.getInt(1) == 1? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return isSuspended;
	}
	
	public int userSuspendActive(UserDTO udto, MemberDTO mdto, 
			ArrayList<Integer> complainIndex, int sus_days, String suspendReason) {
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
					String idx = "";
					for(int i = 0; i<complainIndex.size(); i++) idx += complainIndex.get(i) + ",";
					idx = idx.substring(0, idx.length()-1);
					sql = "update Complain set complete = true, emp_id = ?, completeDate = now()";
					sql += " where idx in("; sql += idx + ")"; 
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getEmp_id());
					pstmt.executeUpdate();
					sql = "select complainer_id from Complain where idx in(" + idx + ")";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					ArrayList<String> complainer_list = new ArrayList<String>();
					while(rs.next()) complainer_list.add(rs.getString(1));
					String complainDuplicated = "";
					for(int i = 0; i<complainer_list.size(); i++) {
						complainDuplicated += "'" + complainer_list.get(i) + "',";
					}
					complainDuplicated = complainDuplicated.substring(0, complainDuplicated.length()-1);
					
					sql = "delete from Complain where complainer_id in (" + complainDuplicated + ") and complete = 0";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();
					
					sql = "update Member set suspended = true, sus_days = ?, sus_date = now(), suspendReason = ? where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, sus_days);
					pstmt.setString(2, suspendReason);
					pstmt.setString(3, udto.getUser_id());
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
	
	public int userSuspendCancel(UserDTO udto, MemberDTO mdto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(mdto.getEmp_pw())) {
					result = 1;
					sql = "update Member set suspended = false, sus_days = 0 where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, udto.getUser_id());
					pstmt.executeUpdate();
				}
				else result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
