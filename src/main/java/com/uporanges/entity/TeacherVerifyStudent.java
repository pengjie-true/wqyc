package com.uporanges.entity;

import java.sql.Timestamp;

public class TeacherVerifyStudent {

	private Student student;
	private Teacher teacher;
	private int join_state;
	private Timestamp join_time;
    private String student_message;
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
	public String getStudent_message() {
		return student_message;
	}
	public void setStudent_message(String student_message) {
		this.student_message = student_message;
	}
	@Override
	public String toString() {
		return "TeacherVerifyStudent [student=" + student + ", teacher=" + teacher + ", join_state=" + join_state
				+ ", join_time=" + join_time + ", student_message=" + student_message + "]";
	}
	public TeacherVerifyStudent(Student student, Teacher teacher, int join_state, Timestamp join_time,
			String student_message) {
		super();
		this.student = student;
		this.teacher = teacher;
		this.join_state = join_state;
		this.join_time = join_time;
		this.student_message = student_message;
	}



}
