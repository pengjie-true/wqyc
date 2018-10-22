package com.uporanges.evo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uporanges.entity.CompanyJob;
import com.uporanges.entity.Job;

public class StuCollectJob {

	private CompanyJob companyJob;
	private TeacherCompany teacherCompany;
	private Job job;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp collect_time;
	public StuCollectJob() {}
	public StuCollectJob(CompanyJob companyJob, TeacherCompany teacherCompany, Job job, Timestamp collect_time) {
		super();
		this.companyJob = companyJob;
		this.teacherCompany = teacherCompany;
		this.job = job;
		this.collect_time = collect_time;
	}
	public CompanyJob getCompanyJob() {
		return companyJob;
	}
	public void setCompanyJob(CompanyJob companyJob) {
		this.companyJob = companyJob;
	}
	public TeacherCompany getTeacherCompany() {
		return teacherCompany;
	}
	public void setTeacherCompany(TeacherCompany teacherCompany) {
		this.teacherCompany = teacherCompany;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Timestamp getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(Timestamp collect_time) {
		this.collect_time = collect_time;
	}
	
}
