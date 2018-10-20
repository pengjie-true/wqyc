package com.uporanges.evo;

public class TeacherCompany {

	private Integer company_id;
	private String company_realname;
	private String company_trade;
	private String company_address;
	private String company_logo_pic;
	public TeacherCompany() {}
	public TeacherCompany(Integer company_id, String company_realname, String company_trade, String company_address,
			String company_logo_pic) {
		super();
		this.company_id = company_id;
		this.company_realname = company_realname;
		this.company_trade = company_trade;
		this.company_address = company_address;
		this.company_logo_pic = company_logo_pic;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
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
	
}
