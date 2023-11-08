package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.employee.dto.UserDTO;

public class TradeDAO extends DAO{
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
	
	public ArrayList tradeList() {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product order by bno desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	}
	
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
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	}
	
	public ArrayList tradeList(String pageCategory) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product";
			if(pageCategory.equals("buy")) sql += " where deal_way = '삽니다'";
			else if(pageCategory.equals("sell")) sql += " where deal_way = '팝니다'";
			else if(pageCategory.equals("complete")) sql += " where deal_status = 0";
			sql += " order by bno desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	}

	public ArrayList tradeList(String pageCategory, 
			String category, String search, String searchKeyword,
			String checkComplete) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where";
			
			if(pageCategory.equals("all")) {
				if(checkComplete == null) {
					sql += " deal_status = 1";
				}
				else {
					sql += " deal_way like '%'";
				}
			}
			else if(!pageCategory.equals("complete")) {
				if(pageCategory.equals("sell")) {
					sql +=  " deal_way = '팝니다'";
				}
				
				else if(pageCategory.equals("buy")) {
					sql +=  " deal_way = '삽니다'";
				}
				
				if(checkComplete == null) {
					sql += "and deal_status = 1";
				}
			}
			
			else {
				sql += " deal_status = 0";
			}

			if(!category.equals("선택")) {
				sql += " and category = '" + category + "'"; 
			}

			if(!search.equals("선택") && searchKeyword != null) {
				sql += " and "+ search +" like '%" + searchKeyword + "%'"; 
			}
			
			sql += " order by bno desc";
			System.out.println("sql : " + sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			li = new ArrayList();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
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
	}
	
	public ArrayList userInfoTrade(UserDTO user) {
		ArrayList li = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where user_id = ? order by bno desc limit 3";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return li;
	}
	
	public TradeDTO tradeContent(int bno) {
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new TradeDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setCategory(rs.getString("category"));
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
	}
}
