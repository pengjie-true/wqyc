package com.uporanges.evo;

import java.sql.Timestamp;

public class TTeacherVerifyStudent {
	
	private Integer student_id;
	private Integer teacher_id;
	private int join_state;
	private Timestamp join_time;
	public TTeacherVerifyStudent() {}
	public TTeacherVerifyStudent(Integer student_id, Integer teacher_id, int join_state, Timestamp join_time) {
		super();
		this.student_id = student_id;
		this.teacher_id = teacher_id;
		this.join_state = join_state;
		this.join_time = join_time;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
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
