package com.uporanges.evo;

public class JobMainInfo {

	private Integer user_id;
	private String user_name;
	private String company_realname;
	private String company_address;
	private Integer job_id;
	private String job_name;
	private String job_type;
	private String job_describe;
	private String job_salary;
	public JobMainInfo() {}
	public JobMainInfo(Integer user_id, String user_name, String company_realname, String company_address,
			Integer job_id, String job_name, String job_type, String job_describe, String job_salary) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.company_realname = company_realname;
		this.company_address = company_address;
		this.job_id = job_id;
		this.job_name = job_name;
		this.job_type = job_type;
		this.job_describe = job_describe;
		this.job_salary = job_salary;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCompany_realname() {
		return company_realname;
	}
	public void setCompany_realname(String company_realname) {
		this.company_realname = company_realname;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
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
