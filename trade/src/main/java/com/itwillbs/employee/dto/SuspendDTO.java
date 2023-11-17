package com.itwillbs.employee.dto;

import java.sql.Timestamp;
import java.util.LinkedList;

public class SuspendDTO {
	private String user_id;
	private Timestamp firstComplainedDate;
	private int count;
	private LinkedList<ComplainDTO> reportList;
	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getFirstComplainedDate() {
		return firstComplainedDate;
	}
	public void setFirstComplainedDate(Timestamp firstComplainedDate) {
		this.firstComplainedDate = firstComplainedDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LinkedList<ComplainDTO> getReportList() {
		return reportList;
	}
	public void setReportList(LinkedList<ComplainDTO> reportList) {
		this.reportList = reportList;
	}
	@Override
	public String toString() {
		return "SuspendDTO [user_id=" + user_id + ", firstComplainedDate=" + firstComplainedDate + ", count="
				+ count + ", reportList=" + reportList + ", toString()=" + super.toString() + "]";
	}
}
