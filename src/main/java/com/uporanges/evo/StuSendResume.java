package com.uporanges.evo;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uporanges.entity.Job;

public class StuSendResume {

	private Job job1;
	private String job_salary1;
	private Job job2;
	private String job_salary2;
	private String resume_expect_workplace1;
	private String resume_expect_workplace2;
	private Integer resume_expect_salary;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date resume_to_work_time;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp deliver_time;
	public StuSendResume() {}
	public StuSendResume(Job job1, String job_salary1, Job job2, String job_salary2, String resume_expect_workplace1,
			String resume_expect_workplace2, Integer resume_expect_salary, Date resume_to_work_time, Timestamp deliver_time) {
		super();
		this.job1 = job1;
		this.job_salary1 = job_salary1;
		this.job2 = job2;
		this.job_salary2 = job_salary2;
		this.resume_expect_workplace1 = resume_expect_workplace1;
		this.resume_expect_workplace2 = resume_expect_workplace2;
		this.resume_expect_salary = resume_expect_salary;
		this.resume_to_work_time = resume_to_work_time;
		this.deliver_time = deliver_time;
	}
	public Job getJob1() {
		return job1;
	}
	public void setJob1(Job job1) {
		this.job1 = job1;
	}
	public String getJob_salary1() {
		return job_salary1;
	}
	public void setJob_salary1(String job_salary1) {
		this.job_salary1 = job_salary1;
	}
	public Job getJob2() {
		return job2;
	}
	public void setJob2(Job job2) {
		this.job2 = job2;
	}
	public String getJob_salary2() {
		return job_salary2;
	}
	public void setJob_salary2(String job_salary2) {
		this.job_salary2 = job_salary2;
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
	public Integer getResume_expect_salary() {
		return resume_expect_salary;
	}
	public void setResume_expect_salary(Integer resume_expect_salary) {
		this.resume_expect_salary = resume_expect_salary;
	}
	public Date getResume_to_work_time() {
		return resume_to_work_time;
	}
	public void setResume_to_work_time(Date resume_to_work_time) {
		this.resume_to_work_time = resume_to_work_time;
	}
	public Timestamp getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(Timestamp deliver_time) {
		this.deliver_time = deliver_time;
	}
	
}
