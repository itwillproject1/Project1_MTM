package com.itwillbs.member.db;

import java.sql.Timestamp;

public class InquiryDTO {
	private int bno;
	private String user_id;
	private String subject;
	private String category;
	private String content;
	private String image;
	private String pw;
	private Timestamp uploadDate;
	private boolean complete;
	private String emp_id;
	private String answerContent;
	private Timestamp answerDate;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Timestamp getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Timestamp answerDate) {
		this.answerDate = answerDate;
	}
	@Override
	public String toString() {
		return "InquiryDTO [bno=" + bno + ", user_id=" + user_id + ", subject=" + subject + ", category=" + category
				+ ", content=" + content + ", image=" + image + ", pw=" + pw + ", uploadDate=" + uploadDate
				+ ", complete=" + complete + ", emp_id=" + emp_id + ", answerContent=" + answerContent + ", answerDate="
				+ answerDate + "]";
	}
	
}
