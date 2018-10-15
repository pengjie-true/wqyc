package com.uporanges.entity;

import org.springframework.web.multipart.MultipartFile;

public class User {

	private Integer user_id;
	private String user_name;
	private String user_password;
	private String user_phone;
	private Integer role_id;
	private MultipartFile user_pic;
	public User() {}
	public User(Integer user_id, String user_name, String user_password, String user_phone, Integer role_id,
			MultipartFile user_pic) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_phone = user_phone;
		this.role_id = role_id;
		this.user_pic = user_pic;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public MultipartFile getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(MultipartFile user_pic) {
		this.user_pic = user_pic;
	}
	
}
