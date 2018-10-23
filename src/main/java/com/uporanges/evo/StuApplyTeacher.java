package com.uporanges.evo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StuApplyTeacher {

	private Integer teacher_id;
	private String teacher_name;
	private String teacher_workschool;
	private String teacher_title;
	private String teacher_post;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp join_time;
    private String student_message;
	public StuApplyTeacher() {}
	public StuApplyTeacher(Integer teacher_id, String teacher_name, String teacher_workschool, String teacher_title,
			String teacher_post, Timestamp join_time, String student_message) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_workschool = teacher_workschool;
		this.teacher_title = teacher_title;
		this.teacher_post = teacher_post;
		this.join_time = join_time;
		this.student_message = student_message;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_workschool() {
		return teacher_workschool;
	}
	public void setTeacher_workschool(String teacher_workschool) {
		this.teacher_workschool = teacher_workschool;
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
	public Timestamp getJoin_time() {
		return join_time;
	}
	public void setJoin_time(Timestamp join_time) {
		this.join_time = join_time;
	}
	public String getStudent_message() {
		return student_message;
	}
	public void setStudent_message(String student_message) {
		this.student_message = student_message;
	}
	
}
