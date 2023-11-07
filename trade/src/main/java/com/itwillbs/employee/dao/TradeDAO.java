package com.itwillbs.employee.dao;

import java.util.ArrayList;

import com.itwillbs.employee.dto.TradeDTO;

public class TradeDAO extends DAO{
	
	
	public ArrayList tradeList(String deal_way, int page) {
		ArrayList tlist = new ArrayList();
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product where deal_way = ? limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deal_way);
			pstmt.setInt(2, (page - 1) * 8);
			pstmt.setInt(3, 8);
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
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				dto.setDeal_status(rs.getInt("deal_status"));
				tlist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB();
		}
		return tlist;
	}

	public ArrayList tradeList(int page) {
		ArrayList tlist = new ArrayList();
		TradeDTO dto = null;
		try {
			con = getCon();
			sql = "select * from Product order by date_time desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (page - 1) * 8);
			pstmt.setInt(2, 8);
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
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				dto.setDeal_status(rs.getInt("deal_status"));
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
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				dto.setDeal_status(rs.getInt("deal_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public ArrayList tradeSearch(String category, String keyword, int page, int limit) {
		ArrayList tList = null;
		TradeDTO dto = null;
		try {
			con = getCon();
			System.out.println("category : " + category);
			System.out.println("keyword : " + keyword);
			sql = "select * from Product where " + category + " = ? order by bno desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, (page - 1) * limit);
			pstmt.setInt(3, limit);
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
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				dto.setDeal_status(rs.getInt("deal_status"));
				tList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tList;
	}
	
}
