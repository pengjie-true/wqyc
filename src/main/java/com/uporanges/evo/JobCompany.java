package com.uporanges.evo;

public class JobCompany {
	
	private JobCompanyInfo jobCompanyInfo;
	private String job_describe;
	private String job_salary;
	public JobCompany() {}
	public JobCompany(JobCompanyInfo jobCompanyInfo, String job_describe, String job_salary) {
		super();
		this.jobCompanyInfo = jobCompanyInfo;
		this.job_describe = job_describe;
		this.job_salary = job_salary;
	}
	public JobCompanyInfo getJobCompanyInfo() {
		return jobCompanyInfo;
	}
	public void setJobCompanyInfo(JobCompanyInfo jobCompanyInfo) {
		this.jobCompanyInfo = jobCompanyInfo;
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
