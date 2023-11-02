package com.itwillbs.product.db;

public class LikeDTO {
	private int bno;
	private String user_id;
	private int like; // 0, 1
	
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
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	
	@Override
	public String toString() {
		return "LikeDTO [bno=" + bno + ", user_id=" + user_id + ", like=" + like + "]";
	}	
	
}
