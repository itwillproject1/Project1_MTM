package com.itwillbs.employee.dto;

import java.sql.Timestamp;

public class MailDTO {
	private int idx;
	private String emp_id;
	private String subject;
	private String content;
	private String image;
	private Timestamp sendDate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public Timestamp getSendDate() {
		return sendDate;
	}
	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}
	@Override
	public String toString() {
		return "MailDTO [idx=" + idx + ", emp_id=" + emp_id + ", subject=" + subject + ", content=" + content
				+ ", image=" + image + ", sendDate=" + sendDate + ", toString()=" + super.toString() + "]";
	}
}
