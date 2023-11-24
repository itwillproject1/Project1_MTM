package com.itwillbs.employee.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.SuspendDTO;
import com.itwillbs.employee.dto.UserDTO;

public class ComplainDAO extends DAO {
	public ArrayList suspendedList(int startRow, int pageSize) {
		// 유저 목록 표시 중 정지된 유저 표시
		ArrayList list = null;
		MemberDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member where suspended = 1 limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
		// userInfoComplain() : 유저 정보에 표시 될 피신고 목록
		HashSet<String> set = new HashSet<String>(); // 중복 확인
		ArrayList list = null;
		ComplainDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Complain where user_id = ? order by uploadDate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, udto.getUser_id());
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				if(set.contains(rs.getString("complainer_id"))) continue;
				dto = new ComplainDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setBno(rs.getInt("bno"));
				dto.setComplainer_id(rs.getString("complainer_id"));
				dto.setComplainReason(rs.getString("complainReason"));
				dto.setUploadDate(rs.getTimestamp("uploadDate"));
				dto.setComplete(rs.getBoolean("complete"));
				list.add(dto);
				set.add(dto.getComplainer_id());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	} // userInfoComplain()

	public ArrayList<SuspendDTO> complainedUserList(int startRow, int pageSize) {
		// complainedUserList() : 피신고자 목록(정지x)
		HashSet<String> set = new HashSet<String>(); // 중복 확인
		ArrayList<SuspendDTO> list = null; // 피신고자 리스트
		ComplainDTO cdto = null; // 신고 데이터
		SuspendDTO sdto = null; // 피신고자 데이터
		try {
			con = getCon();
			// 신고 리스트 중복 제거로 조회(유저 명만)
			sql = "select distinct user_id from Complain where complete = false limit ?, ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			list = new ArrayList<SuspendDTO>();
			while (rs.next()) {
				// 유저 명만 신고 리스트에 추가
				sdto = new SuspendDTO();
				sdto.setuser_id(rs.getString(1));
				list.add(sdto);
			}

			LinkedList<ComplainDTO> dtoList = null;
			for (int i = 0; i < list.size(); i++) {
				dtoList = new LinkedList<ComplainDTO>();
				sdto = list.get(i);
				// 피신고자에게 신고한 목록 조회
				sql = "select * from Complain where complete = false and user_id = ? order by uploadDate";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sdto.getuser_id());
				rs = pstmt.executeQuery();
				int count = 0;
				while (rs.next()) {
					if (count == 0) {
						// 최초로 신고된 일자
						sdto.setFirstComplainedDate(rs.getTimestamp("uploadDate"));
					}
					// 신고처리가 되지 않은 목록 중 중복된 신고 제거
					if (set.contains(rs.getString("complainer_id")))
						continue; // 만약 hashSet에 있는 경우 그 신고는 스킵
					cdto = new ComplainDTO();
					cdto.setIdx(rs.getInt("idx"));
					cdto.setBno(rs.getInt("bno"));
					cdto.setComplainer_id(rs.getString("complainer_id"));
					cdto.setComplainReason(rs.getString("complainReason"));
					cdto.setUploadDate(rs.getTimestamp("uploadDate"));
					count++;
					set.add(cdto.getComplainer_id()); // 중복 제거를 위해 신고자 추가
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
		// complainedUserCount() : 피신고자 총 인원 return, 중복 x
		int result = 0;
		try {
			con = getCon();
			sql = "select count(distinct user_id) from Complain where complete = false";
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
	} // complainedUserCount()

	// isSuspended() : 회원 정지 확인
	public boolean isSuspended(UserDTO dto) {
		boolean isSuspended = false;
		try {
			con = getCon();
			sql = "select suspended from Member where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			rs = pstmt.executeQuery();
			if (rs.next())
				isSuspended = rs.getInt(1) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return isSuspended;
	} // isSuspended()

	public int userSuspendActive(UserDTO udto, MemberDTO mdto, ArrayList<Integer> complainIndex, int sus_days,
			String suspendReason) {
		// 유저 정지 실행
		int result = -1;
		try {
			con = getCon();
			// 관리자의 비밀번호 및 아이디 확인
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("emp_pw").equals(mdto.getEmp_pw())) {
					result = 1;
					String idx = "";
					// where idx in ( 1, 2, 3) -> 신고 번호 다중 체크
					for (int i = 0; i < complainIndex.size(); i++)
						idx += complainIndex.get(i) + ",";
					idx = idx.substring(0, idx.length() - 1);

					// 신고자 신고 처리
					sql = "update Complain set complete = true, emp_id = ?, completeDate = now()";
					sql += " where idx in(";
					sql += idx + ")";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getEmp_id());
					pstmt.executeUpdate();

					// 다중 선택된 신고 내역 중 신고자를 찾기 위해 목록 번호 들고오기
					sql = "select complainer_id from Complain where idx in(" + idx + ")";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					ArrayList<String> complainer_list = new ArrayList<String>();
					while (rs.next())
						complainer_list.add(rs.getString(1));

					// where complainer_id in('a', 'b', 'c')
					String complainDuplicated = "";
					for (int i = 0; i < complainer_list.size(); i++) {
						complainDuplicated += "'" + complainer_list.get(i) + "',";
					}
					complainDuplicated = complainDuplicated.substring(0, complainDuplicated.length() - 1);

					// 신고되지 않은 컬럼 중 다중 신고 제거
					sql = "delete from Complain where complainer_id in (" + complainDuplicated + ") and complete = 0";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();

					// 회원 테이블에서 일정기간 정지 처리
					sql = "update Member set suspended = 1, sus_date = now(), sus_days = ?, suspendReason = ? WHERE (user_id = ?);";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, sus_days);
					pstmt.setString(2, suspendReason);
					pstmt.setString(3, udto.getUser_id());
					pstmt.executeUpdate();

					// 신고된 멤버의 이메일 조회
					sql = "select email from Member where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, udto.getUser_id());
					rs = pstmt.executeQuery();
					if (rs.next())
						udto.setEmail(rs.getString(1));

					// 정지이력에 아이디 및 이메일 등 추가
					sql = "insert into SuspendHistory (user_id, user_email, suspendReason, suspendDays, suspendDate, emp_id) values"
							+ " (?, ?, ?, ?, now(), ?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, udto.getUser_id());
					pstmt.setString(2, udto.getEmail());
					pstmt.setString(3, suspendReason);
					pstmt.setInt(4, sus_days);
					pstmt.setString(5, mdto.getEmp_id());
					pstmt.executeUpdate();
					
					// 정지 처리된 게시물에 찜한 기록 삭제
					sql = "delete from Likes where bno in(select bno from Complain where user_id = ? and complete = 1)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, udto.getUser_id());
					pstmt.executeUpdate();
					
					// 신고된 게시물 삭제
					sql = "delete from Product where bno in(select bno from Complain where user_id = ? and complete = 1)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, udto.getUser_id());
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
	} // userSuspendActive()

	public int userSuspendCancel(UserDTO udto, MemberDTO mdto) {
		// 유저 정지 취소
		int result = -1;
		try {
			con = getCon();
			// 관리자의 비밀번호 및 아이디 확인
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmp_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(mdto.getEmp_pw())) {
					result = 1;
					// 회원의 정지 상태, 정지 일자 변경
					sql = "update Member set suspended = false, sus_days = 0 where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, udto.getUser_id());
					pstmt.executeUpdate();
				} else
					result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // userSuspendCancel()
}
