package com.uporanges.entity;

import java.util.List;

public class Job {

	private Integer job_id;
	private String job_name;
	private String job_type;
	private List<CompanyJob> companyJob;
	public Job() {}
	public Job(Integer job_id, String job_name, String job_type, List<CompanyJob> companyJob) {
		super();
		this.job_id = job_id;
		this.job_name = job_name;
		this.job_type = job_type;
		this.companyJob = companyJob;
	}
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	public List<CompanyJob> getCompanyJob() {
		return companyJob;
	}
	public void setCompanyJob(List<CompanyJob> companyJob) {
		this.companyJob = companyJob;
	}
	
}
