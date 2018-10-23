package com.uporanges.evo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uporanges.entity.Job;

public class StuResumeCheck {

	private Integer send_resume_id;
	private StuResumeCompany stuResumeCompany;
	private Job job1;
	private Job job2;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp deliver_time;
	public StuResumeCheck() {}
	public StuResumeCheck(Integer send_resume_id, StuResumeCompany stuResumeCompany, Job job1, Job job2,
			Timestamp deliver_time) {
		super();
		this.send_resume_id = send_resume_id;
		this.stuResumeCompany = stuResumeCompany;
		this.job1 = job1;
		this.job2 = job2;
		this.deliver_time = deliver_time;
	}
	public Integer getSend_resume_id() {
		return send_resume_id;
	}
	public void setSend_resume_id(Integer send_resume_id) {
		this.send_resume_id = send_resume_id;
	}
	public StuResumeCompany getStuResumeCompany() {
		return stuResumeCompany;
	}
	public void setStuResumeCompany(StuResumeCompany stuResumeCompany) {
		this.stuResumeCompany = stuResumeCompany;
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
	public Timestamp getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(Timestamp deliver_time) {
		this.deliver_time = deliver_time;
	}
	
}
