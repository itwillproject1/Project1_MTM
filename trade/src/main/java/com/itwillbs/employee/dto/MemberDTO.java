package com.itwillbs.employee.dto;

import java.sql.Date;

public class MemberDTO {
	private String emp_id;
	private String emp_pw;
	private String name;
	private String email;
	private String address;
	private String tel;
	private Date join_date;
	private int active;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "MemberDTO [emp_id=" + emp_id + ", emp_pw=" + emp_pw + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", tel=" + tel + ", join_date=" + join_date
				+ ", active=" + active + ", toString()=" + super.toString() + "]";
	}
}
