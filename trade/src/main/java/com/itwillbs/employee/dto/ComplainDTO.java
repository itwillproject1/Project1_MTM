package com.itwillbs.employee.dto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ComplainDTO {
	private int idx;
	private int bno;
	private String complainer_id;
	private String user_id;
	private String complainReason;
	private Timestamp uploadDate;
	private boolean complete;
	private String emp_id;
	private Timestamp completeDate;
	private int count;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getComplainer_id() {
		return complainer_id;
	}
	public void setComplainer_id(String complainer_id) {
		this.complainer_id = complainer_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComplainReason() {
		return complainReason;
	}
	public void setComplainReason(String complainReason) {
		this.complainReason = complainReason;
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
	public Timestamp getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Timestamp completeDate) {
		this.completeDate = completeDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ComplainDTO [idx=" + idx + ", bno=" + bno + ", complainer_id=" + complainer_id + ", user_id=" + user_id
				+ ", complainReason=" + complainReason + ", uploadDate=" + uploadDate + ", complete=" + complete
				+ ", emp_id=" + emp_id + ", completeDate=" + completeDate + ", count=" + count + ", toString()="
				+ super.toString() + "]";
	}
}
