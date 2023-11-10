package com.itwillbs.product.db;

public class LikeDTO {
	private int bno;
	private String user_id;
	private int do_like; // 0, 1
	
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
	public int getDo_like() {
		return do_like;
	}
	public void setDo_like(int do_like) {
		this.do_like = do_like;
	}
	
	@Override
	public String toString() {
		return "LikeDTO [bno=" + bno + ", user_id=" + user_id + ", do_like=" + do_like + "]";
	}	
	
}
