package com.uporanges.entity;

import java.sql.Date;

public class StudentSendResume {

	private int send_resume_id;
	private Student student;
	private StudentResume studentResume;
	private Company company;
	private Job job1;
	private Job job2;
	private String resume_expect_workplace1;
	private String resume_expect_workplace2;
	private int resume_expect_salary;
	private Date resume_to_work_time;
	private int delivar_state;
	private Date deliver_time;
	public StudentSendResume() {}
	public StudentSendResume(int send_resume_id, Student student, StudentResume studentResume, Company company,
			Job job1, Job job2, String resume_expect_workplace1, String resume_expect_workplace2,
			int resume_expect_salary, Date resume_to_work_time, int delivar_state, Date deliver_time) {
		super();
		this.send_resume_id = send_resume_id;
		this.student = student;
		this.studentResume = studentResume;
		this.company = company;
		this.job1 = job1;
		this.job2 = job2;
		this.resume_expect_workplace1 = resume_expect_workplace1;
		this.resume_expect_workplace2 = resume_expect_workplace2;
		this.resume_expect_salary = resume_expect_salary;
		this.resume_to_work_time = resume_to_work_time;
		this.delivar_state = delivar_state;
		this.deliver_time = deliver_time;
	}
	public int getSend_resume_id() {
		return send_resume_id;
	}
	public void setSend_resume_id(int send_resume_id) {
		this.send_resume_id = send_resume_id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentResume getStudentResume() {
		return studentResume;
	}
	public void setStudentResume(StudentResume studentResume) {
		this.studentResume = studentResume;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Job getJob1() {
		return job1;
	}
	public void setJob1(Job job1) {
		this.job1 = job1;
	}
	public Job getJob2() {
		return job2;
	}
	public void setJob2(Job job2) {
		this.job2 = job2;
	}
	public String getResume_expect_workplace1() {
		return resume_expect_workplace1;
	}
	public void setResume_expect_workplace1(String resume_expect_workplace1) {
		this.resume_expect_workplace1 = resume_expect_workplace1;
	}
	public String getResume_expect_workplace2() {
		return resume_expect_workplace2;
	}
	public void setResume_expect_workplace2(String resume_expect_workplace2) {
		this.resume_expect_workplace2 = resume_expect_workplace2;
	}
	public int getResume_expect_salary() {
		return resume_expect_salary;
	}
	public void setResume_expect_salary(int resume_expect_salary) {
		this.resume_expect_salary = resume_expect_salary;
	}
	public Date getResume_to_work_time() {
		return resume_to_work_time;
	}
	public void setResume_to_work_time(Date resume_to_work_time) {
		this.resume_to_work_time = resume_to_work_time;
	}
	public int getDelivar_state() {
		return delivar_state;
	}
	public void setDelivar_state(int delivar_state) {
		this.delivar_state = delivar_state;
	}
	public Date getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(Date deliver_time) {
		this.deliver_time = deliver_time;
	}
	
}
