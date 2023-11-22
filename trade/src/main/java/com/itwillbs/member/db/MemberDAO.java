package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.product.db.ProductDTO;

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

		return con;
	}

	// 공통) 자원 해제
	private void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public void insertMember(MemberDTO dto) {

		try {
			con = getCon();
			sql = "insert into Member (user_id,password,email,user_name,jumin,gender,phone,address,user_nickname,profile,recommend,agree,date) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getPassword());

			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getUser_name());
			pstmt.setString(5, dto.getJumin());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getPhone());
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getUser_nickname());

			pstmt.setString(10, dto.getProfile());

			pstmt.setString(11, dto.getRecommend());
			pstmt.setString(12, dto.getAgree());
			pstmt.setString(12, dto.getAgree());

			pstmt.executeUpdate();

			if (dto.getRecommend() != null) {
				sql = "update Member set pay = pay + 1000 where user_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getRecommend());

				pstmt.executeUpdate();
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
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
			if (rs.next()) { // 회원정보가 있음
				if (dto.getPassword().equals(rs.getString("password"))) {
					// 비밀번호 동일
					result = 1;
				} else {
					// 비밀번호 다름
					result = 0;
				}
			} else {// 회원정보 없음
				result = -1;
			}

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

			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}

	public MemberDTO getMember(String id) {
		MemberDTO dto = null;

		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select * from Member where user_id=?";
			pstmt = con.prepareStatement(sql);
			// ???
			pstmt.setString(1, id);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리 (DB에 저장된 정보(rs)를 DTO로 저장)
			if (rs.next()) {
				dto = new MemberDTO();

				// rs => dto 저장
				dto.setUser_id(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setJumin(rs.getString("jumin"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail(rs.getString("email"));

				dto.setAddress(rs.getString("address"));
				dto.setUser_nickname(rs.getString("user_nickname"));
				dto.setProfile(rs.getString("profile"));
				dto.setPhone(rs.getString("phone"));
				dto.setRecommend(rs.getString("recommend"));
				dto.setAgree(rs.getString("agree"));
				dto.setPay(rs.getInt("pay"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return dto;
	}

	public int updateMember(MemberDTO dto) {
		int result = -1; // -1 0 1

		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 작성(select) & pstmt객체
			sql = "select password from Member where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터처리
			if (rs.next()) {

				if (dto.getUser_id() != null) {
					// 3. sql 작성(update) & pstmt객체

					sql = "update Member set password=?,user_nickname=?,email=?,address=?,phone=?,agree=?,profile=? where user_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getPassword());
					pstmt.setString(2, dto.getUser_nickname());
					pstmt.setString(3, dto.getEmail());
					pstmt.setString(4, dto.getAddress());
					pstmt.setString(5, dto.getPhone());
					pstmt.setString(6, dto.getAgree());
					pstmt.setString(7, dto.getProfile());
					pstmt.setString(8, dto.getUser_id());

					// 4. sql 실행
					result = pstmt.executeUpdate();
					// result = 1;

				} else {
					result = 0; // 사용자의 비밀번호 오류
				}
			} else {
				result = -1; // 회원정보X,에러발생
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;
	}

	public int deleteMember(MemberDTO dto) {
		int result = -1; // -1 0 1

		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select password from Member where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());

			// 4. sql 실행
			rs = pstmt.executeQuery();

			// 5. 데이터 처리
			if (rs.next()) {
				if (dto.getPassword().equals(rs.getString("password"))) {
					// 3. sql 작성(delete) & pstmt 객체
					// 작성자의 거래하지 않은 상품 삭제
					// 제안상품 삭제
					sql = "delete from SuggestSell where buyer_user_id = ? or seller_user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());
					pstmt.setString(2, dto.getUser_id());

					pstmt.executeUpdate();

					// 찜 한 글의 찜 수 -1
					sql = "select * from Likes where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());

					rs = pstmt.executeQuery();

					while (rs.next()) {
						sql = "update Product set like_count = like_count-1 where bno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, rs.getInt("bno"));

						pstmt.executeUpdate();
					}

					// 내가 찜한 목록 삭제
					sql = "delete from Likes where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());

					pstmt.executeUpdate();

					// 내 상품에 찜한 목록 삭제
					sql = "select bno from Product where user_id = ?";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());

					rs = pstmt.executeQuery();

					while (rs.next()) {
						sql = "delete from Likes where bno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, rs.getInt("bno"));

						pstmt.executeUpdate();
					}

					// 등록 상품 중 거래 전 상품만 삭제
					sql = "delete from Product where user_id = ? and deal_status = 1";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());

					pstmt.executeUpdate();

					// 회원 탈퇴 수행
					sql = "update Member set active = 0 where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getUser_id());

					result = pstmt.executeUpdate(); // 삭제완료

				} else {
					result = 0; // 비밀번호 오류
				}
			} else {
				result = -1; // 회원정보 없음
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;
	}

	// 결제금액 충전
	public void Pay(MemberDTO dto) {
		try {
			con = getCon();
			sql = "update Member set pay = pay + ? where user_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPay());
			pstmt.setString(2, dto.getUser_id());

			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			closeDB();
		}

	}

	public ArrayList<ProductDTO> getMPBlist(String user_id) {
		ArrayList<ProductDTO> MPBlist = new ArrayList<ProductDTO>();
		ProductDTO dto = null;
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 구문 작성(select) & pstmt 객체
			sql = "SELECT * FROM Product where user_id = ?"; // views 내림차순으로 8개까지 정렬

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user_id);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));

				// 글 하나의 정보를 배열의 한칸에 저장
				MPBlist.add(dto);
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return MPBlist;
	}

	public MemberDTO findidmember(MemberDTO iddto) {
		int result = -1; // -1 0 1

		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select * from Member where user_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, iddto.getUser_name());
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if (rs.next()) {

				if (iddto.getJumin().equals(rs.getString("jumin"))) {
					if (iddto.getPhone().equals(rs.getString("phone"))) {
						// 3. sql 작성(delete) & pstmt 객체
						iddto.setUser_id(rs.getString("user_id"));
						// 4. sql 실행
						result = 2; // 아이디찾기완료
					} else {
						result = 1; // 전화번호가 맞지 않음
					}
				} else {
					result = 0; // 주민번호가 맞지 않음
				}
			} else {
				result = -1; // 회원이름이 없음
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return iddto;
	}

	public int findidmember2(MemberDTO iddto) {
		int result = -1; // -1 0 1

		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select * from Member where user_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, iddto.getUser_name());
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if (rs.next()) {

				if (iddto.getJumin().equals(rs.getString("jumin"))) {
					if (iddto.getPhone().equals(rs.getString("phone"))) {
						// 3. sql 작성(delete) & pstmt 객체
						iddto.setUser_id(rs.getString("user_id"));
						// 4. sql 실행
						result = 2; // 아이디찾기완료
					} else {
						result = 1; // 전화번호가 맞지 않음
					}
				} else {
					result = 0; // 주민번호가 맞지 않음
				}
			} else {
				result = -1; // 회원이름이 없음
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;

	}

	// 거래를 진행하는 메서드(판매자)
	public void productpay(MemberDTO dto) {

		try {

			con = getCon();

			sql = "update Member set pay = pay + ? where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPay());
			pstmt.setString(2, dto.getUser_id());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}//

	// 거래를 진행하는 메서드(구매자)
	public void buyer_productpay(MemberDTO dto) {

		try {

			con = getCon();

			sql = "update Member set pay = pay - ? where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPay());
			pstmt.setString(2, dto.getUser_id());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}//

	public MemberDTO findpwmember(MemberDTO pwdto) {
		int result = -1; // -1 0 1

		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select * from Member where user_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwdto.getUser_name());
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if (rs.next()) {

				if (pwdto.getUser_id().equals(rs.getString("user_id"))) {
					pwdto.setPassword(rs.getString("passwoard"));
					result = 1; // 일치
				} else {
					result = 0; // 아이디가 맞지않음
				}
			} else {
				result = -1; // 회원이름이 없음
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return pwdto;
	}

	public int findpwmember2(MemberDTO pwdto) {
		int result = -1; // -1 0 1

		try {
			// 1.2. 디비 연결
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select * from Member where user_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwdto.getUser_name());
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if (rs.next()) {

				if (pwdto.getUser_id().equals(rs.getString("user_id"))) {
					pwdto.setPassword(rs.getString("password"));
					result = 1; // 일치

				} else {
					result = 0; // 아이디가 맞지않음
				}
			} else {
				result = -1; // 회원이름이 없음
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;
	}

	// 구매자의 정보를 불러오는 메서드
	public MemberDTO user_search(String user_id) {
		MemberDTO dto = null;

		try {

			con = getCon();

			sql = "select user_id, user_name, phone, address, pay from Member where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new MemberDTO();

				// rs => dto 저장
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setPay(rs.getInt("pay"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return dto;
	}

	public String user_sus(String user_id) {
		String result = "";
		try {
			con = getCon();
			sql = "select datediff(now(), date_add(sus_date, interval sus_days day)) as '만료일자' from Member where user_id = ?";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1) >= 0) {
					// 정지 해제
					sql = "update Member set sus_days = 0, suspended = 0 where user_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();
				}
				else {
					// 정지 x
					sql = "select sus_days, sus_date, suspendReason from Member where user_id = ?";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						String sus_days = rs.getString(1);
						Date sus_date = rs.getDate(2);
						String suspendReason = rs.getString(3);
						result = user_id + "은 " + suspendReason + "의 사유로 인해" + sus_date + "부터"
								+ sus_days + "일 동안 정지처리 되었습니다.";
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}

}
