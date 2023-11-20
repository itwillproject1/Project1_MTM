package com.itwillbs.product.db;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeHistoryDTO {
	
	private int order_id;
	private String user_id;
	private String deal_way;
	private int bno;
	private String trader_id;
	private int price;
	private String address;
	private Timestamp tradeDate;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDeal_way() {
		return deal_way;
	}
	public void setDeal_way(String deal_way) {
		this.deal_way = deal_way;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTrader_id() {
		return trader_id;
	}
	public void setTrader_id(String trader_id) {
		this.trader_id = trader_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Timestamp tradeDate) {
		this.tradeDate = tradeDate;
	}
	
	@Override
	public String toString() {
		return "TradeHistoryDTO [order_id=" + order_id + ", user_id=" + user_id + ", deal_way=" + deal_way + ", bno="
				+ bno + ", trader_id=" + trader_id + ", price=" + price + ", address=" + address + ", tradeDate="
				+ tradeDate + "]";
	}
	
	
	
}