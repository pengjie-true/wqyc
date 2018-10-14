package com.uporanges.entity;

import java.sql.Date;
import java.util.List;

public class Teacher {

	private User user;
	private String teacher_name;
	private Date teacher_birthday;
	private String teacher_identity;
	private String teacher_email;
	private String teacher_WeChat;
	private String teacher_hometown;
	private String teacher_sex;
	private String teacher_workschool;
	private Code teacher_major1;
	private Code teacher_major2;
	private String teacher_title;
	private String teacher_post;
	private Code teacher_education1;
	private Code teacher_education2;
	private String teacher_achievements;
	private String teacher_work_describe;
	private String teacher_invite_code;
	private Integer teacher_teach_state;
	private List<CompanyVerifyTeacher> companyVerifyTeacher;
	public Teacher() {}
	public Teacher(User user, String teacher_name, Date teacher_birthday, String teacher_identity,
			String teacher_email, String teacher_WeChat, String teacher_hometown, String teacher_sex,
			String teacher_workschool, Code teacher_major1, Code teacher_major2, String teacher_title,
			String teacher_post, Code teacher_education1, Code teacher_education2, String teacher_achievements,
			String teacher_work_describe, String teacher_invite_code, Integer teacher_teach_state,
			List<CompanyVerifyTeacher> companyVerifyTeacher) {
		super();
		this.user = user;
		this.teacher_name = teacher_name;
		this.teacher_birthday = teacher_birthday;
		this.teacher_identity = teacher_identity;
		this.teacher_email = teacher_email;
		this.teacher_WeChat = teacher_WeChat;
		this.teacher_hometown = teacher_hometown;
		this.teacher_sex = teacher_sex;
		this.teacher_workschool = teacher_workschool;
		this.teacher_major1 = teacher_major1;
		this.teacher_major2 = teacher_major2;
		this.teacher_title = teacher_title;
		this.teacher_post = teacher_post;
		this.teacher_education1 = teacher_education1;
		this.teacher_education2 = teacher_education2;
		this.teacher_achievements = teacher_achievements;
		this.teacher_work_describe = teacher_work_describe;
		this.teacher_invite_code = teacher_invite_code;
		this.teacher_teach_state = teacher_teach_state;
		this.companyVerifyTeacher = companyVerifyTeacher;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public Date getTeacher_birthday() {
		return teacher_birthday;
	}
	public void setTeacher_birthday(Date teacher_birthday) {
		this.teacher_birthday = teacher_birthday;
	}
	public String getTeacher_identity() {
		return teacher_identity;
	}
	public void setTeacher_identity(String teacher_identity) {
		this.teacher_identity = teacher_identity;
	}
	public String getTeacher_email() {
		return teacher_email;
	}
	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}
	public String getTeacher_WeChat() {
		return teacher_WeChat;
	}
	public void setTeacher_WeChat(String teacher_WeChat) {
		this.teacher_WeChat = teacher_WeChat;
	}
	public String getTeacher_hometown() {
		return teacher_hometown;
	}
	public void setTeacher_hometown(String teacher_hometown) {
		this.teacher_hometown = teacher_hometown;
	}
	public String getTeacher_sex() {
		return teacher_sex;
	}
	public void setTeacher_sex(String teacher_sex) {
		this.teacher_sex = teacher_sex;
	}
	public String getTeacher_workschool() {
		return teacher_workschool;
	}
	public void setTeacher_workschool(String teacher_workschool) {
		this.teacher_workschool = teacher_workschool;
	}
	public Code getTeacher_major1() {
		return teacher_major1;
	}
	public void setTeacher_major1(Code teacher_major1) {
		this.teacher_major1 = teacher_major1;
	}
	public Code getTeacher_major2() {
		return teacher_major2;
	}
	public void setTeacher_major2(Code teacher_major2) {
		this.teacher_major2 = teacher_major2;
	}
	public String getTeacher_title() {
		return teacher_title;
	}
	public void setTeacher_title(String teacher_title) {
		this.teacher_title = teacher_title;
	}
	public String getTeacher_post() {
		return teacher_post;
	}
	public void setTeacher_post(String teacher_post) {
		this.teacher_post = teacher_post;
	}
	public Code getTeacher_education1() {
		return teacher_education1;
	}
	public void setTeacher_education1(Code teacher_education1) {
		this.teacher_education1 = teacher_education1;
	}
	public Code getTeacher_education2() {
		return teacher_education2;
	}
	public void setTeacher_education2(Code teacher_education2) {
		this.teacher_education2 = teacher_education2;
	}
	public String getTeacher_achievements() {
		return teacher_achievements;
	}
	public void setTeacher_achievements(String teacher_achievements) {
		this.teacher_achievements = teacher_achievements;
	}
	public String getTeacher_work_describe() {
		return teacher_work_describe;
	}
	public void setTeacher_work_describe(String teacher_work_describe) {
		this.teacher_work_describe = teacher_work_describe;
	}
	public String getTeacher_invite_code() {
		return teacher_invite_code;
	}
	public void setTeacher_invite_code(String teacher_invite_code) {
		this.teacher_invite_code = teacher_invite_code;
	}
	public Integer getTeacher_teach_state() {
		return teacher_teach_state;
	}
	public void setTeacher_teach_state(Integer teacher_teach_state) {
		this.teacher_teach_state = teacher_teach_state;
	}
	public List<CompanyVerifyTeacher> getCompanyVerifyTeacher() {
		return companyVerifyTeacher;
	}
	public void setCompanyVerifyTeacher(List<CompanyVerifyTeacher> companyVerifyTeacher) {
		this.companyVerifyTeacher = companyVerifyTeacher;
	}
	
}
