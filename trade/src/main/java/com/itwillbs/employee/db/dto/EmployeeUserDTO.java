package com.itwillbs.employee.db.dto;

import java.sql.Timestamp;

public class EmployeeUserDTO {
	private String user_id;
	private String user_pw;
	private String email;
	private String name;
	private String jumin; // 주민등록번호는 등록 불법 -> 생년월일로 지정
	private String gender;
	private String phone;
	private String address;
	private String nickname;
	private boolean agree;
	private Timestamp regdate;
	private int point;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isAgree() {
		return agree;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "EmployeeUserDAO [user_id=" + user_id + ", user_pw=" + user_pw + ", email=" + email + ", name=" + name
				+ ", jumin=" + jumin + ", gender=" + gender + ", phone=" + phone + ", address=" + address
				+ ", nickname=" + nickname + ", agree=" + agree + ", regdate=" + regdate + ", point=" + point
				+ ", toString()=" + super.toString() + "]";
	}
}
