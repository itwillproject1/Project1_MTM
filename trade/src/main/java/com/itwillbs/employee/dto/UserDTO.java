package com.itwillbs.employee.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class UserDTO {
	private String user_id;
	private String user_pw;
	private String email;
	private String user_name;
	private String jumin; // 주민등록번호는 등록 불법 -> 생년월일로 지정
	private String gender;
	private String phone;
	private String address;
	private String profile;
	private String user_nickname;
	private String agree;
	private Timestamp regdate;
	private int pay;
	private boolean suspended;
	private Date sus_date;
	private int sus_days;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public Date getSus_date() {
		return sus_date;
	}
	public void setSus_date(Date sus_date) {
		this.sus_date = sus_date;
	}
	public int getSus_days() {
		return sus_days;
	}
	public void setSus_days(int sus_days) {
		this.sus_days = sus_days;
	}
	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", email=" + email + ", user_name=" + user_name
				+ ", jumin=" + jumin + ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", profile="
				+ profile + ", user_nickname=" + user_nickname + ", agree=" + agree + ", regdate=" + regdate + ", pay="
				+ pay + ", suspended=" + suspended + ", sus_date=" + sus_date + ", sus_days=" + sus_days
				+ ", toString()=" + super.toString() + "]";
	}
}
