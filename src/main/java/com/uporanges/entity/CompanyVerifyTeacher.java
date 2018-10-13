package com.uporanges.entity;

import java.sql.Date;

public class CompanyVerifyTeacher {

	private Company company;
	private Teacher teacher;
	private Integer verify_state;
	private Date verify_time;
	public CompanyVerifyTeacher() {}
	public CompanyVerifyTeacher(Company company, Teacher teacher, Integer verify_state, Date verify_time) {
		super();
		this.company = company;
		this.teacher = teacher;
		this.verify_state = verify_state;
		this.verify_time = verify_time;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Integer getVerify_state() {
		return verify_state;
	}
	public void setVerify_state(Integer verify_state) {
		this.verify_state = verify_state;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	
}
