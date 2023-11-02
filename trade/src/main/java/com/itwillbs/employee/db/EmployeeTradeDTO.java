package com.itwillbs.employee.db;

import java.sql.Timestamp;

public class EmployeeTradeDTO {
	private int bno;
	private String user_id;
	private String deal_way;
	private String title;
	private String category;
	private String brand;
	private int price;
	private String product_status;
	private String content;
	private int views;
	private Timestamp date_time;
	private String file_name;
	private int like_count;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	
	@Override
	public String toString() {
		return "EmployeeTradeDTO [bno=" + bno + ", user_id=" + user_id + ", deal_way=" + deal_way + ", title=" + title
				+ ", category=" + category + ", brand=" + brand + ", price=" + price + ", product_status="
				+ product_status + ", content=" + content + ", views=" + views + ", date_time=" + date_time
				+ ", file_name=" + file_name + ", like_count=" + like_count + ", toString()=" + super.toString() + "]";
	}	
}
