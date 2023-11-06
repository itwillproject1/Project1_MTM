package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class MemberDAO {
	// 공통 변수 선언
		private Connection con = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		private String sql = "";
		
		// 공통) 디비 연결하기
		private Connection getCon() throws Exception {
			Context initCTX = new InitialContext();
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/mvc");
			con = ds.getConnection();
			
			System.out.println("DAO: DB 연결 성공");
			System.out.println("DAO: " + con);
			
			return con;
		}
		
		// 공통) 자원 해제
		private void closeDB() {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
			
			
			// 회원가입
		public void insertMember(MemberDTO dto) {
				
				try {
					con = getCon();
					sql = "insert into Member (user_id,password,passwordcheck,email,user_name,jumin,gender,phone,address,user_nickname,profile,recommend,agree) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());
					pstmt.setString(2, dto.getPassword());
					pstmt.setString(3, dto.getPasswordcheck());
					pstmt.setString(4, dto.getEmail());
					pstmt.setString(5, dto.getUser_name());
					pstmt.setString(6, dto.getJumin());
					pstmt.setString(7, dto.getGender());
					pstmt.setString(8, dto.getPhone());
					pstmt.setString(9, dto.getAddress());
					pstmt.setString(10, dto.getUser_nickname());
					
					pstmt.setString(11, dto.getProfile());
					
					pstmt.setString(12, dto.getRecommend());
					pstmt.setString(13, dto.getAgree());
					
					pstmt.executeUpdate();
					System.out.println("회원가입 완료");
				} catch (Exception e) {
					
					e.printStackTrace();
				}finally {
					closeDB();
				}
				
		}
		
		public int loginMember(MemberDTO dto) {
			int result = -1; // -1 0 1
			
			try {
				// 1.2. 디비연결
				con = getCon();
				// 3. sql 작성 & pstmt 객체
				sql = "select password from Member where user_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getUser_id());
				// 4. sql 실행
				rs = pstmt.executeQuery();
				// 5. 데이터 처리
				if(rs.next()) { // 회원정보가 있음
					if(dto.getPassword().equals(rs.getString("password"))) {
						// 비밀번호 동일
						result = 1;
					}else {
						// 비밀번호 다름
						result = 0;
					}
				}else {// 회원정보 없음
					result = -1;
				}
				
				System.out.println(" DAO : 로그인 처리 완료 ("+result+")");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return result;
		}
			
			
		// 아이디 중복 확인
					public int checkid(MemberDTO dto) {
						int result = -1;
								try {
									con = getCon();
									sql = "select user_id from Member where user_id = ?";
									pstmt = con.prepareStatement(sql);
									pstmt.setString(1, dto.getUser_id());
									rs = pstmt.executeQuery();
									
									if(rs.next()) {
											result = 1;
										}else {
											result = 0;
										}
									
									
									System.out.println("아이디 중복 확인 " + result);
									
								} catch (Exception e) {
									
									e.printStackTrace();
								} finally {
									closeDB();
								}
								return result;
					}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}