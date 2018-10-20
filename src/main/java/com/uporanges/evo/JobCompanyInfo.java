package com.uporanges.evo;

public class JobCompanyInfo {

	private UserInfo userInfo;
	private String company_realname;
	private String company_address;
	public JobCompanyInfo() {}
	public JobCompanyInfo(UserInfo userInfo, String company_realname, String company_address) {
		super();
		this.userInfo = userInfo;
		this.company_realname = company_realname;
		this.company_address = company_address;
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
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	
}
