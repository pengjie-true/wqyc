package com.uporanges.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentCollectJob {
	
	private Student student;
	private Job job;
	private Company company;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp collect_time;
	public StudentCollectJob() {}
	public StudentCollectJob(Student student, Job job, Company company, Timestamp collect_time) {
		super();
		this.student = student;
		this.job = job;
		this.company = company;
		this.collect_time = collect_time;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Timestamp getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(Timestamp collect_time) {
		this.collect_time = collect_time;
	}

}
