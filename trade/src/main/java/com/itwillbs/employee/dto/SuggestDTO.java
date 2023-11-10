package com.itwillbs.employee.dto;

import java.sql.Timestamp;

public class SuggestDTO {
	// 거래 제안 DTO
	// TradeContent 들어갈 때 조회 가능
	// Product + SuggestSell 테이블 조회
	private int bno;
	private String seller_id;
	private int seller_price;
	private String buyer_id;
	private int buyer_price;
	private String title;
	private String file_name;
	private int views;
	private Timestamp date_time;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public int getSeller_price() {
		return seller_price;
	}
	public void setSeller_price(int seller_price) {
		this.seller_price = seller_price;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getBuyer_price() {
		return buyer_price;
	}
	public void setBuyer_price(int buyer_price) {
		this.buyer_price = buyer_price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Timestamp getDate_time() {
		return date_time;
	}
	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}
	@Override
	public String toString() {
		return "SuggestDTO [bno=" + bno + ", seller_id=" + seller_id + ", seller_price=" + seller_price + ", buyer_id="
				+ buyer_id + ", buyer_price=" + buyer_price + ", title=" + title + ", file_name=" + file_name
				+ ", views=" + views + ", date_time=" + date_time + ", toString()=" + super.toString() + "]";
	}
}
