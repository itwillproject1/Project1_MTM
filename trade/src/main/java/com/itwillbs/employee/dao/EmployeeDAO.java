package com.itwillbs.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.employee.dto.UserDTO;

public class EmployeeDAO {
	private Connection con = null;
	private ResultSet rs = null;
	private String sql = "";
	private PreparedStatement pstmt = null;
	
	// Connection 설정
	private Connection getCon() throws Exception{
		Context initCTX = new InitialContext();
		Context envCTX = (Context)initCTX.lookup("java:comp/env");
		DataSource ds = (DataSource)envCTX.lookup("jdbc/mvc");
		con = ds.getConnection();
		System.out.println("DAO : DB 연결 성공");
		System.out.println("DAO : " + con);
		return con;
	}// getCon();
	
	// 데이터베이스 닫기
	private void CloseDB() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // CloseDB();
	
	// loginEmployee() : 관리자 로그인
	public int loginEmployee(MemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("emp_pw").equals(dto.getEmp_pw())) {
					result = 1;
				}
				else result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // loginEmployee();
	
	// loadProfile() : 관리자 프로필 불러오기
	public MemberDTO loadProfile(String id) {
		MemberDTO result = null;
		try {
			con = getCon();
			sql = "select * from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberDTO();
				result.setEmp_id(rs.getString("emp_id"));
				result.setEmp_pw(rs.getString("emp_pw"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setAddress(rs.getString("address"));
				result.setTel(rs.getString("tel"));
				result.setJoin_date(rs.getDate("join_date"));
				result.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // loadProfile();
	
	
	// changeProfile() : 관리자 프로필 편집
	public int changeProfile(MemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "update from Employee where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // changeProfile();

	// employeePasswordFind() : 관리자 비밀번호 찾기
	public int employePwFind(MemberDTO dto) {
		int result = -1;
		try {
			con = getCon();
			sql = "select email from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(0).equals(dto.getEmp_id())) {
					result = 1;
				}
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // employeePasswordFind();
	
	// employeePwChange() : 관리자 비밀번호 변경
	public int employeePwChange(MemberDTO dto, String newPw) {
		int result = -1;
		try {
			con = getCon();
			sql = "select emp_pw from Employees where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(0).equals(dto.getEmp_pw())) {
					result = 1;
					sql = "update from Employees ";
					pstmt = con.prepareStatement(sql);
				}
				result = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // employeePwChange();
	
	// loadEmployeeList() : 직원 목록 return
	public ArrayList loadEmployeeList(int currentPage) {
		// 1페이지 8명
		int content = 8;
		ArrayList empList = null;
		try {
			con = getCon();
			sql = "select * from Employees order by join_date limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, currentPage-1);
			pstmt.setInt(2, content);
			rs = pstmt.executeQuery();
			empList = new ArrayList();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setJoin_date(rs.getDate("join_date"));
				dto.setEmail(rs.getString("email"));
				empList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return empList;
	} // loadEemployeeList();
	
	// employeeCount() : 직원 수 return
	public int employeeCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Employee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	} // employeeCount();
		
	public ArrayList tradeList(String deal_way) {
		ArrayList tlist = new ArrayList();
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where deal_way = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "'" + deal_way + "'");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setBrand(rs.getString("brand"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setContent(rs.getString("content"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setViews(rs.getInt("views"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setProduct_status(rs.getString("product_status"));
				tlist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return tlist;
	}

	public ArrayList tradeList(int range) {
		ArrayList tlist = new ArrayList();
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product order by date_time desc limit ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, range);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setBrand(rs.getString("brand"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setContent(rs.getString("content"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setViews(rs.getInt("views"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setProduct_status(rs.getString("product_status"));
				
				tlist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return tlist;
	}
	
	public int tradeCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Product";
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
	
	public TradeDTO tradeContent(int bno) {
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(bno);
				dto.setBrand(rs.getString("brand"));
				dto.setCategory(rs.getString("category"));
				dto.setContent(rs.getString("content"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getInt("price"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setViews(rs.getInt("views"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public ArrayList tradeSearch(String category, String keyword) {
		ArrayList tList = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where " + category + " = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setBrand(rs.getString("brand"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setContent(rs.getString("content"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setViews(rs.getInt("views"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setProduct_status(rs.getString("product_status"));
				tList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tList;
	}
	
	public ArrayList userList() {
		ArrayList list = null;
		UserDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				dto = new UserDTO();
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_nickname(rs.getString("user_nickname"));
				dto.setPhone(rs.getString("phone"));
				//dto.setRegdate(rs.getTimestamp("regdate"));
				//dto.setPoint(rs.getInt("point"));
				//dto.setAgree(rs.getBoolean("agree"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public ArrayList userSearch(String search) {
		ArrayList list = null;
		UserDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member where user_id like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				dto = new UserDTO();
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_nickname(rs.getString("user_nickname"));
				dto.setPhone(rs.getString("phone"));
				//dto.setRegdate(rs.getTimestamp("regdate"));
				//dto.setPoint(rs.getInt("point"));
				//dto.setAgree(rs.getBoolean("agree"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}
	
	public int userCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Member";
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
	
	public UserDTO userInfo(String user_id) {
		// userContent(String user_id) : 유저 정보 조회
		UserDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Member where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUser_id(user_id);
				dto.setUser_nickname(rs.getString("user_nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setAddress(rs.getString("address"));
				dto.setJumin(rs.getString("jumin"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	} // userContent();
	
	
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
					sql = "";
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
					sql = "";
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
					sql = "";
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
			sql = "";
			pstmt = con.prepareStatement(sql);
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
			sql = "";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ComplainDTO();
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
}
