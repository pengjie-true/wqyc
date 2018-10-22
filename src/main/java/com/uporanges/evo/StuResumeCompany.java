package com.uporanges.evo;

public class StuResumeCompany {

	private Integer company_id;
	private String company_realname;
	private String company_logo_pic;
	private String company_phone1;
	private String company_phone2;
	private String company_email;
	public StuResumeCompany() {}
	public StuResumeCompany(Integer company_id, String company_realname, String company_logo_pic, String company_phone1,
			String company_phone2, String company_email) {
		super();
		this.company_id = company_id;
		this.company_realname = company_realname;
		this.company_logo_pic = company_logo_pic;
		this.company_phone1 = company_phone1;
		this.company_phone2 = company_phone2;
		this.company_email = company_email;
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
	public String getCompany_logo_pic() {
		return company_logo_pic;
	}
	public void setCompany_logo_pic(String company_logo_pic) {
		this.company_logo_pic = company_logo_pic;
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
	
}
