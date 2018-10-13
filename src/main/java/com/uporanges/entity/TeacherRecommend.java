package com.uporanges.entity;

import java.sql.Date;

public class TeacherRecommend {

	private int recommend_id;
	private Teacher teacher;
	private Student student;
	private StudentSendResume studentSendResume;
	private Company company;
	private String recommend_describe;
	private Date recommend_time;
	public TeacherRecommend() {}
	public TeacherRecommend(int recommend_id, Teacher teacher, Student student, StudentSendResume studentSendResume,
			Company company, String recommend_describe, Date recommend_time) {
		super();
		this.recommend_id = recommend_id;
		this.teacher = teacher;
		this.student = student;
		this.studentSendResume = studentSendResume;
		this.company = company;
		this.recommend_describe = recommend_describe;
		this.recommend_time = recommend_time;
	}
	public int getRecommend_id() {
		return recommend_id;
	}
	public void setRecommend_id(int recommend_id) {
		this.recommend_id = recommend_id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentSendResume getStudentSendResume() {
		return studentSendResume;
	}
	public void setStudentSendResume(StudentSendResume studentSendResume) {
		this.studentSendResume = studentSendResume;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getRecommend_describe() {
		return recommend_describe;
	}
	public void setRecommend_describe(String recommend_describe) {
		this.recommend_describe = recommend_describe;
	}
	public Date getRecommend_time() {
		return recommend_time;
	}
	public void setRecommend_time(Date recommend_time) {
		this.recommend_time = recommend_time;
	}
	
}
