package com.uporanges.evo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uporanges.entity.Code;

public class TeacherOtherInfo {

	private UserInfo userInfo;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date teacher_birthday;
	private String teacher_email;
	private String teacher_WeChat;
	private String teacher_hometown;
	private String teacher_sex;
	private Code teacher_education1;
	private Code teacher_education2;
	private String teacher_achievements;
	private String teacher_work_describe;
	private List<TeacherCompany> teacherCompany;
	public TeacherOtherInfo() {}
	public TeacherOtherInfo(UserInfo userInfo, Date teacher_birthday, String teacher_email, String teacher_WeChat,
			String teacher_hometown, String teacher_sex, Code teacher_education1, Code teacher_education2,
			String teacher_achievements, String teacher_work_describe, List<TeacherCompany> teacherCompany) {
		super();
		this.userInfo = userInfo;
		this.teacher_birthday = teacher_birthday;
		this.teacher_email = teacher_email;
		this.teacher_WeChat = teacher_WeChat;
		this.teacher_hometown = teacher_hometown;
		this.teacher_sex = teacher_sex;
		this.teacher_education1 = teacher_education1;
		this.teacher_education2 = teacher_education2;
		this.teacher_achievements = teacher_achievements;
		this.teacher_work_describe = teacher_work_describe;
		this.teacherCompany = teacherCompany;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Date getTeacher_birthday() {
		return teacher_birthday;
	}
	public void setTeacher_birthday(Date teacher_birthday) {
		this.teacher_birthday = teacher_birthday;
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
	public List<TeacherCompany> getTeacherCompany() {
		return teacherCompany;
	}
	public void setTeacherCompany(List<TeacherCompany> teacherCompany) {
		this.teacherCompany = teacherCompany;
	}
	
}
