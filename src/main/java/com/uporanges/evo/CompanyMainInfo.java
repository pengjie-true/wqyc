package com.uporanges.evo;

public class CompanyMainInfo {

	private UserInfo user;
	private String company_realname;
	private String company_trade;
	private String company_nature;
	private String company_address;
	private String company_logo_pic;
	private String company_brief;
	public CompanyMainInfo() {}
	public CompanyMainInfo(UserInfo user, String company_realname, String company_trade, String company_nature,
			String company_address, String company_logo_pic, String company_brief) {
		super();
		this.user = user;
		this.company_realname = company_realname;
		this.company_trade = company_trade;
		this.company_nature = company_nature;
		this.company_address = company_address;
		this.company_logo_pic = company_logo_pic;
		this.company_brief = company_brief;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
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
	
}
