package com.itwillbs.employee.dto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ComplainDTO {
	private int bno;
	private String reporter_id;
	private String reported_id;
	private String complainReason;
	private Timestamp uploadDate;
	private boolean complete;
	private String emp_id;
	private Timestamp completeDate;
	private int count;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReporter_id() {
		return reporter_id;
	}
	public void setReporter_id(String reporter_id) {
		this.reporter_id = reporter_id;
	}
	public String getReported_id() {
		return reported_id;
	}
	public void setReported_id(String reported_id) {
		this.reported_id = reported_id;
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
		return "ComplainDTO [bno=" + bno + ", reporter_id=" + reporter_id + ", reported_id=" + reported_id
				+ ", complainReason=" + complainReason + ", uploadDate=" + uploadDate + ", complete=" + complete
				+ ", emp_id=" + emp_id + ", completeDate=" + completeDate + ", count=" + count + ", toString()="
				+ super.toString() + "]";
	}
}
