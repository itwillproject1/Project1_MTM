package com.itwillbs.member.db;

public class MemberDTO {

	private String user_id;
	private String password;
	private String passwordcheck;
	private String email;
	private String user_name;
	private String jumin;
	private String gender;
	private String phone;
	private String address;
	private String user_nickname;
	private String profile;
	private String recommend;
	private String agree;
	
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordcheck() {
		return passwordcheck;
	}


	public void setPasswordcheck(String passwordcheck) {
		this.passwordcheck = passwordcheck;
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


	public String getUser_nickname() {
		return user_nickname;
	}


	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getRecommend() {
		return recommend;
	}


	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}


	public String getAgree() {
		return agree;
	}


	public void setAgree(String agree) {
		this.agree = agree;
	}


	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", password=" + password + ", passwordcheck=" + passwordcheck
				+ ", email=" + email + ", user_name=" + user_name + ", jumin=" + jumin + ", gender=" + gender
				+ ", phone=" + phone + ", address=" + address + ", user_nickname=" + user_nickname + ", profile="
				+ profile + ", recommend=" + recommend + ", agree=" + agree + "]";
	}


	
	
	
		
}
