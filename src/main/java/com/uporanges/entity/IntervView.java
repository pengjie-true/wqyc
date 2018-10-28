package com.uporanges.entity;

import java.util.Date;

public class IntervView {

	private int interview_id;
	private User user_id;
	private User student_id;
	private String interview_address;
	private Date interview_time;
	private StudentSendResume send_resume_id;
	@Override
	public String toString() {
		return "IntervView [interview_id=" + interview_id + ", user_id=" + user_id + ", student_id=" + student_id
				+ ", interview_address=" + interview_address + ", interview_time=" + interview_time
				+ ", send_resume_id=" + send_resume_id + "]";
	}
	public int getInterview_id() {
		return interview_id;
	}
	public void setInterview_id(int interview_id) {
		this.interview_id = interview_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public User getStudent_id() {
		return student_id;
	}
	public void setStudent_id(User student_id) {
		this.student_id = student_id;
	}
	public String getInterview_address() {
		return interview_address;
	}
	public void setInterview_address(String interview_address) {
		this.interview_address = interview_address;
	}
	public Date getInterview_time() {
		return interview_time;
	}
	public void setInterview_time(Date interview_time) {
		this.interview_time = interview_time;
	}
	public StudentSendResume getSend_resume_id() {
		return send_resume_id;
	}
	public void setSend_resume_id(StudentSendResume send_resume_id) {
		this.send_resume_id = send_resume_id;
	}
	public IntervView(int interview_id, User user_id, User student_id, String interview_address, Date interview_time,
			StudentSendResume send_resume_id) {
		super();
		this.interview_id = interview_id;
		this.user_id = user_id;
		this.student_id = student_id;
		this.interview_address = interview_address;
		this.interview_time = interview_time;
		this.send_resume_id = send_resume_id;
	}
	public IntervView() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
