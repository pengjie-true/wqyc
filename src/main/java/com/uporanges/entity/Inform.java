package com.uporanges.entity;

import java.sql.Date;

public class Inform {

	private Integer inform_id;
	private User userid;
	private User informed_userid;
	private String inform_title;
	private String inform_content;
	private Integer infrom_type;
	private Date infrom_time;
	public Inform() {}
	public Inform(Integer inform_id, User userid, User informed_userid, String inform_title, String inform_content,
			Integer infrom_type, Date infrom_time) {
		super();
		this.inform_id = inform_id;
		this.userid = userid;
		this.informed_userid = informed_userid;
		this.inform_title = inform_title;
		this.inform_content = inform_content;
		this.infrom_type = infrom_type;
		this.infrom_time = infrom_time;
	}
	public Integer getInform_id() {
		return inform_id;
	}
	public void setInform_id(Integer inform_id) {
		this.inform_id = inform_id;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public User getInformed_userid() {
		return informed_userid;
	}
	public void setInformed_userid(User informed_userid) {
		this.informed_userid = informed_userid;
	}
	public String getInform_title() {
		return inform_title;
	}
	public void setInform_title(String inform_title) {
		this.inform_title = inform_title;
	}
	public String getInform_content() {
		return inform_content;
	}
	public void setInform_content(String inform_content) {
		this.inform_content = inform_content;
	}
	public Integer getInfrom_type() {
		return infrom_type;
	}
	public void setInfrom_type(Integer infrom_type) {
		this.infrom_type = infrom_type;
	}
	public Date getInfrom_time() {
		return infrom_time;
	}
	public void setInfrom_time(Date infrom_time) {
		this.infrom_time = infrom_time;
	}
	
}
