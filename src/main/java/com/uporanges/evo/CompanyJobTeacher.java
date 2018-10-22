package com.uporanges.evo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uporanges.entity.CompanyJob;

public class CompanyJobTeacher {
	
	private UserInfo userInfo;
	private String company_realname;
	private String company_trade;
	private String company_nature;
	private String company_address;
	private String company_phone1;
	private String company_phone2;
	private String company_email;
	private String company_business_license;
	private String company_logo_pic;
	private String company_brief;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date create_time;
	private String company_legal_person;
	private List<CompanyJob> companyJob;
	private List<TeacherMainInfo> companyTeacher;
	public CompanyJobTeacher() {}
	public CompanyJobTeacher(UserInfo userInfo, String company_realname, String company_trade, String company_nature,
			String company_address, String company_phone1, String company_phone2, String company_email,
			String company_business_license, String company_logo_pic, String company_brief, Date create_time,
			String company_legal_person, List<CompanyJob> companyJob, List<TeacherMainInfo> companyTeacher) {
		super();
		this.userInfo = userInfo;
		this.company_realname = company_realname;
		this.company_trade = company_trade;
		this.company_nature = company_nature;
		this.company_address = company_address;
		this.company_phone1 = company_phone1;
		this.company_phone2 = company_phone2;
		this.company_email = company_email;
		this.company_business_license = company_business_license;
		this.company_logo_pic = company_logo_pic;
		this.company_brief = company_brief;
		this.create_time = create_time;
		this.company_legal_person = company_legal_person;
		this.companyJob = companyJob;
		this.companyTeacher = companyTeacher;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getCompany_realname() {
		return company_realname;
	}
	public void setCompany_realname(String company_realname) {
		this.company_realname = company_realname;
	}
	public String getCompany_trade() {
		return company_trade;
	}
	public void setCompany_trade(String company_trade) {
		this.company_trade = company_trade;
	}
	public String getCompany_nature() {
		return company_nature;
	}
	public void setCompany_nature(String company_nature) {
		this.company_nature = company_nature;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_phone1() {
		return company_phone1;
	}
	public void setCompany_phone1(String company_phone1) {
		this.company_phone1 = company_phone1;
	}
	public String getCompany_phone2() {
		return company_phone2;
	}
	public void setCompany_phone2(String company_phone2) {
		this.company_phone2 = company_phone2;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getCompany_business_license() {
		return company_business_license;
	}
	public void setCompany_business_license(String company_business_license) {
		this.company_business_license = company_business_license;
	}
	public String getCompany_logo_pic() {
		return company_logo_pic;
	}
	public void setCompany_logo_pic(String company_logo_pic) {
		this.company_logo_pic = company_logo_pic;
	}
	public String getCompany_brief() {
		return company_brief;
	}
	public void setCompany_brief(String company_brief) {
		this.company_brief = company_brief;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCompany_legal_person() {
		return company_legal_person;
	}
	public void setCompany_legal_person(String company_legal_person) {
		this.company_legal_person = company_legal_person;
	}
	public List<CompanyJob> getCompanyJob() {
		return companyJob;
	}
	public void setCompanyJob(List<CompanyJob> companyJob) {
		this.companyJob = companyJob;
	}
	public List<TeacherMainInfo> getCompanyTeacher() {
		return companyTeacher;
	}
	public void setCompanyTeacher(List<TeacherMainInfo> companyTeacher) {
		this.companyTeacher = companyTeacher;
	}

}
