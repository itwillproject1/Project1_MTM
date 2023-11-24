package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.SuggestDTO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.employee.dto.UserDTO;

public class TradeDAO extends DAO {
	// tradeCount() : 활성화 된 상품 개수
	public int tradeCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from Product where deal_status = 1";
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
	}// tradeCount()
	
	// tradeCount() : 상품 개수, 카테고리로 검색
	public int tradeCount(String pageCategory, String checkComplete) {
		int result = 0;
		try {
			con = getCon();
			if (checkComplete == null) {
				if (pageCategory.equals("all"))
					sql = "select count(*) from Product where deal_status = 1";
				else if (pageCategory.equals("buy"))
					sql = "select count(*) from Product where deal_way = '삽니다' and deal_status = 1";
				else if (pageCategory.equals("sell"))
					sql = "select count(*) from Product where deal_way = '팝니다' and deal_status = 1";
				else if (pageCategory.equals("complete"))
					sql = "select count(*) from Product where deal_status = 0";
			} else {
				if (pageCategory.equals("all"))
					sql = "select count(*) from Product";
				else if (pageCategory.equals("buy"))
					sql = "select count(*) from Product where deal_way = '삽니다'";
				else if (pageCategory.equals("sell"))
					sql = "select count(*) from Product where deal_way = '팝니다'";
				else if (pageCategory.equals("complete"))
					sql = "select count(*) from Product where deal_status = 0";
			}
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
	} // tradeCount()
	
	// tradeCount() : 상품 개수 return, 카테고리, 검색
	public int tradeCount(String pageCategory, String category, String search, String searchKeyword,
			String checkComplete) {
		int result = 0;
		try {
			con = getCon();
			if (checkComplete == null) {
				if (pageCategory.equals("all"))
					sql = "select count(*) from Product where deal_status = 1";
				else if (pageCategory.equals("buy"))
					sql = "select count(*) from Product where deal_way = '삽니다' and deal_status = 1";
				else if (pageCategory.equals("sell"))
					sql = "select count(*) from Product where deal_way = '팝니다' and deal_status = 1";
				else if (pageCategory.equals("complete"))
					sql = "select count(*) from Product where deal_status = 0";

			} else {
				if (pageCategory.equals("all"))
					sql = "select count(*) from Product where 1 = 1";
				else if (pageCategory.equals("buy"))
					sql = "select count(*) from Product where deal_way = '삽니다'";
				else if (pageCategory.equals("sell"))
					sql = "select count(*) from Product where deal_way = '팝니다'";
				else if (pageCategory.equals("complete"))
					sql = "select count(*) from Product where deal_status = 0";
			}

			if (!category.equals("선택")) {
				sql += " and category = '" + category + "'";
			}

			if (!search.equals("선택") && searchKeyword != null) {
				sql += " and " + search + " like '%" + searchKeyword + "%'";
			}

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
	}// tradeCount()

	// tradeList() : 메인 페이지에서 사용하는 최신 거래
	public ArrayList tradeList(int limit) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product order by bno desc limit ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limit);
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				li.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	} // tradeList()

	// tradeList() : 카테고리별 테이블 조회, 페이징 처리
	public ArrayList tradeList(String pageCategory, int startRow, int pageSize) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product";
			// 카테고리
			if (pageCategory.equals("buy"))
				sql += " where deal_way = '삽니다'";
			else if (pageCategory.equals("sell"))
				sql += " where deal_way = '팝니다'";
			else if (pageCategory.equals("complete"))
				sql += " where deal_status = 0";
			// 페이징 처리
			sql += " order by bno desc limit ?,?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				li.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	} // tradeList()

	// tradeList() : 카테고리, 검색 별 테이블 조회, 페이징 처리
	public ArrayList tradeList(String pageCategory, String category, String search, String searchKeyword,
			String checkComplete, int startRow, int pageSize) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where";

			if (pageCategory.equals("all")) {
				if (checkComplete == null) {
					sql += " deal_status = 1";
				} else {
					sql += " deal_way like '%'";
				}
			} else if (!pageCategory.equals("complete")) {
				if (pageCategory.equals("sell")) {
					sql += " deal_way = '팝니다'";
				}

				else if (pageCategory.equals("buy")) {
					sql += " deal_way = '삽니다'";
				}

				if (checkComplete == null) {
					sql += "and deal_status = 1";
				}
			}

			else {
				sql += " deal_status = 0";
			}

			if (!category.equals("선택")) {
				sql += " and category = '" + category + "'";
			}

			if (!search.equals("선택") && searchKeyword != null) {
				sql += " and " + search + " like '%" + searchKeyword + "%'";
			}

			sql += " order by bno desc limit ?,?";
			System.out.println("sql : " + sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				li.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	} // tradeList()

	// userInfoTrade() : 유저 정보 내의 거래 리스트
	public ArrayList userInfoTrade(UserDTO user) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where user_id = ? order by bno desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			System.out.println("sql : " + sql + ", user_id : " + user.getUser_id());
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				System.out.println(dto);
				li.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	} // userInfoTrade()

	// tradeContent() : 거래 상세 정보
	public TradeDTO tradeContent(int bno) {
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return dto;
	}// tradeContent()

	public int suggestCount(int bno, String deal_way) {
		// suggestCount() : 거래 제안 개수 return
		int result = 0;
		try {
			con = getCon();
			if (deal_way.equals("삽니다"))
				sql = "select count(*) from SuggestSell where buy_bno = ?";
			else // deal_way.equals("팝니다")
				sql = "select count(*) from SuggestSell where sell_bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return result;
	}

	public ArrayList suggestList(int bno, String deal_way) {
		// suggestList() : 거래 제안 리스트 return
		// 구매자 정보에 들어간 경우 조회할 수 있도록 함
		ArrayList sellList = null;
		SuggestDTO dto = null;
		try {
			con = getCon();
			if (deal_way.equals("삽니다")) {
				sql = "select * from SuggestSell where buy_bno = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rs = pstmt.executeQuery();
				sellList = new ArrayList();
				while (rs.next()) {
					dto = new SuggestDTO();
					dto.setBno(rs.getInt("sell_bno"));
					dto.setSeller_id(rs.getString("seller_user_id"));
					dto.setSeller_price(rs.getInt("seller_price"));
					dto.setBuyer_price(0);
					sellList.add(dto);
				}
			} else {
				sql = "select * from SuggestSell where sell_bno = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rs = pstmt.executeQuery();
				sellList = new ArrayList();

				while (rs.next()) {
					dto = new SuggestDTO();
					dto.setBno(rs.getInt("buy_bno"));
					dto.setBuyer_id(rs.getString("buyer_user_id"));
					dto.setBuyer_price(rs.getInt("buyer_price"));
					sellList.add(dto);
				}
			}
			for (int i = 0; i < sellList.size(); i++) {
				dto = (SuggestDTO) sellList.get(i);
				sql = "select * from Product where bno = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getBno());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					dto.setViews(rs.getInt("views"));
					dto.setDate_time(rs.getTimestamp("date_time"));
					dto.setTitle(rs.getString("title"));
				}
				sellList.set(i, dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return sellList;
	}// suggestList()

	// userInfoLike() : 회원의 찜목록 return
	public ArrayList userInfoLike(UserDTO udto) {
		ArrayList list = null;
		ArrayList<Integer> bnoList = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select bno from Likes where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, udto.getUser_id());
			rs = pstmt.executeQuery();
			bnoList = new ArrayList<Integer>();
			while (rs.next()) {
				bnoList.add(rs.getInt(1));
			}
			list = new ArrayList();
			if (bnoList.size() > 0) {
				for (int i = 0; i < bnoList.size(); i++) {
					sql = "select * from Product where bno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, bnoList.get(i));
					rs = pstmt.executeQuery();
					if (rs.next()) {
						dto = new TradeDTO();
						dto.setBno(rs.getInt("bno"));
						dto.setUser_id(rs.getString("user_id"));
						dto.setDeal_way(rs.getString("deal_way"));
						dto.setCategory(rs.getString("category"));
						dto.setBrand(rs.getString("brand"));
						dto.setTitle(rs.getString("title"));
						dto.setContent(rs.getString("content"));
						dto.setProduct_status(rs.getString("product_status"));
						dto.setDeal_status(rs.getInt("deal_status"));
						dto.setDate_time(rs.getTimestamp("date_time"));
						dto.setFile_name(rs.getString("file_name"));
						dto.setLike_count(rs.getInt("like_count"));
						dto.setPrice(rs.getInt("price"));
						dto.setDeal_status(rs.getInt("deal_status"));
						dto.setDeal_user_id(rs.getString("deal_user_id"));
						list.add(dto);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return list;
	}// userInfoLike()

	// tradeHistoryCount() : 거래 내역 개수
	public int tradeHistoryCount() {
		int result = 0;
		try {
			con = getCon();
			sql = "select count(*) from TradeHistory";
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
	} // tradeHistoryCount()

	// tradeHistory() : 거래 내역, 페이징 처리
	public ArrayList tradeHistory(int startRow, int pageSize) {
		ArrayList th = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			// Product 테이블과 join 처리
			sql = "select th.order_id, th.user_id, th.trader_id, p.category, "
					+ "th.price, p.title, th.deal_way, tradeDate from TradeHistory th "
					+ "left outer join Product p on th.bno = p.bno " + "order by order_id limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			th = new ArrayList();
			while (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt(1));
				dto.setUser_id(rs.getString(2));
				dto.setDeal_user_id(rs.getString(3));
				dto.setCategory(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setTitle(rs.getString(6));
				dto.setDeal_way(rs.getString(7));
				dto.setDate_time(rs.getTimestamp(8));
				th.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return th;
	} // tradeHistory()

	// tradeHistorySearch() : 거래 내역, 검색 및 페이징 처리
	public ArrayList tradeHistorySearch(String category, String search, String searchKeyword, int startRow,
			int pageSize) {
		ArrayList th = null;
		TradeDTO dto = null;

		try {
			con = getCon();
			sql = "select th.bno bno, th.user_id, th.trader_id, "
					+ "p.category, th.price, p.title, th.deal_way, tradeDate "
					+ "from TradeHistory th left outer join Product p on th.bno = p.bno " + "where ";

			if (search == null || searchKeyword == null) {
				sql += "category = '" + category + "'";
			} else if (category == null) {
				sql += "th." + search + " like '%" + searchKeyword + "%'";
			} else {
				sql += "th." + search + " like '%" + searchKeyword + "%' and category = '" + category + "'";
			}
			sql += " order by th.bno limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			th = new ArrayList();
			while (rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt(1));
				dto.setUser_id(rs.getString(2));
				dto.setDeal_user_id(rs.getString(3));
				dto.setCategory(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setTitle(rs.getString(6));
				dto.setDeal_way(rs.getString(7));
				dto.setDate_time(rs.getTimestamp(8));
				th.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return th;
	} // tradeHistorySearch()
}
