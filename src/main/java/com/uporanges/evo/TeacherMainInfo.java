package com.uporanges.evo;

public class TeacherMainInfo {

	private UserInfo userInfo;
	private String teacher_name;
	private String teacher_hometown;
	private String teacher_sex;
	private String teacher_workschool;
	private String teacher_major1;
	private String teacher_major2;
	private String teacher_title;
	private String teacher_post;
	private Integer teacher_teach_state;
	public TeacherMainInfo() {}
	public TeacherMainInfo(UserInfo userInfo, String teacher_name, String teacher_hometown, String teacher_sex,
			String teacher_workschool, String teacher_major1, String teacher_major2, String teacher_title,
			String teacher_post, Integer teacher_teach_state) {
		super();
		this.userInfo = userInfo;
		this.teacher_name = teacher_name;
		this.teacher_hometown = teacher_hometown;
		this.teacher_sex = teacher_sex;
		this.teacher_workschool = teacher_workschool;
		this.teacher_major1 = teacher_major1;
		this.teacher_major2 = teacher_major2;
		this.teacher_title = teacher_title;
		this.teacher_post = teacher_post;
		this.teacher_teach_state = teacher_teach_state;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
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
	public String getTeacher_major1() {
		return teacher_major1;
	}
	public void setTeacher_major1(String teacher_major1) {
		this.teacher_major1 = teacher_major1;
	}
	public String getTeacher_major2() {
		return teacher_major2;
	}
	public void setTeacher_major2(String teacher_major2) {
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
	public Integer getTeacher_teach_state() {
		return teacher_teach_state;
	}
	public void setTeacher_teach_state(Integer teacher_teach_state) {
		this.teacher_teach_state = teacher_teach_state;
	}
	
}
