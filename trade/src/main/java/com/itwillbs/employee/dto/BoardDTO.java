package com.itwillbs.employee.dto;

import java.sql.Date;

public class BoardDTO {
	private int index;
	private String emp_id;	// 작성자 아이디
	private String subject;
	private String content;
	private String image;
	private Date uploadDate;
	private int readcount;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
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
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
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
		return "BoardDTO [index=" + index + ", emp_id=" + emp_id + ", subject=" + subject + ", content=" + content
				+ ", image=" + image + ", uploadDate=" + uploadDate + ", readcount=" + readcount + ", toString()="
				+ super.toString() + "]";
	}
}
