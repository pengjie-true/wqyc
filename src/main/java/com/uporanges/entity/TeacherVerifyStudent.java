package com.uporanges.entity;

import java.sql.Timestamp;

public class TeacherVerifyStudent {

	private Student student;
	private Teacher teacher;
	private int join_state;
	private Timestamp join_time;

	public TeacherVerifyStudent() {}
	public TeacherVerifyStudent(Student student, Teacher teacher, int join_state, Timestamp join_time) {
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
	public Timestamp getJoin_time() {
		return join_time;
	}
	public void setJoin_time(Timestamp join_time) {
		this.join_time = join_time;
	}

}
