package com.itwillbs.product.db;

public class SuggestSellDTO {
	private int index;
	private int buy_bno;
	private int sell_bno;
	private String buyer_user_id;
	private String seller_user_id;
	private int buyer_price;
	private int seller_price;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getBuy_bno() {
		return buy_bno;
	}
	public void setBuy_bno(int buy_bno) {
		this.buy_bno = buy_bno;
	}
	public int getSell_bno() {
		return sell_bno;
	}
	public void setSell_bno(int sell_bno) {
		this.sell_bno = sell_bno;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}
	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}
	public String getSeller_user_id() {
		return seller_user_id;
	}
	public void setSeller_user_id(String seller_user_id) {
		this.seller_user_id = seller_user_id;
	}
	public int getBuyer_price() {
		return buyer_price;
	}
	public void setBuyer_price(int buyer_price) {
		this.buyer_price = buyer_price;
	}
	public int getSeller_price() {
		return seller_price;
	}
	public void setSeller_price(int seller_price) {
		this.seller_price = seller_price;
	}

	@Override
	public String toString() {
		return "SuggestSellDTO [index=" + index + ", buy_bno=" + buy_bno + ", sell_bno=" + sell_bno + ", buyer_user_id="
				+ buyer_user_id + ", seller_user_id=" + seller_user_id + ", buyer_price=" + buyer_price
				+ ", seller_price=" + seller_price + "]";
	}
	

	
}
