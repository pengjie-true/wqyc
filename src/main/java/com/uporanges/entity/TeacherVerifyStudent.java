package com.uporanges.entity;

import java.sql.Date;

public class TeacherVerifyStudent {

	private Student student;
	private Teacher teacher;
	private int join_state;
	private Date join_time;
	public TeacherVerifyStudent() {}
	public TeacherVerifyStudent(Student student, Teacher teacher, int join_state, Date join_time) {
		super();
		this.student = student;
		this.teacher = teacher;
		this.join_state = join_state;
		this.join_time = join_time;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public int getJoin_state() {
		return join_state;
	}
	public void setJoin_state(int join_state) {
		this.join_state = join_state;
	}
	public Date getJoin_time() {
		return join_time;
	}
	public void setJoin_time(Date join_time) {
		this.join_time = join_time;
	}
	
}
