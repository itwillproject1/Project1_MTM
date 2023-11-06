package com.itwillbs.employee.dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int bno;
	private String emp_id;	// 작성자 아이디
	private String category;
	private String subject;
	private String content;
	private String image;
	private Timestamp uploadDate;
	private int readcount;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", emp_id=" + emp_id + ", category=" + category + ", subject=" + subject
				+ ", content=" + content + ", image=" + image + ", uploadDate=" + uploadDate + ", readcount="
				+ readcount + ", toString()=" + super.toString() + "]";
	}
}
