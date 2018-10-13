package com.uporanges.entity;

public class CompanyJob {

	private Company company;
	private Job job;
	private String job_describe;
	private String job_salary;
	public CompanyJob() {}
	public CompanyJob(Company company, Job job, String job_describe, String job_salary) {
		super();
		this.company = company;
		this.job = job;
		this.job_describe = job_describe;
		this.job_salary = job_salary;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getJob_describe() {
		return job_describe;
	}
	public void setJob_describe(String job_describe) {
		this.job_describe = job_describe;
	}
	public String getJob_salary() {
		return job_salary;
	}
	public void setJob_salary(String job_salary) {
		this.job_salary = job_salary;
	}
	
}
