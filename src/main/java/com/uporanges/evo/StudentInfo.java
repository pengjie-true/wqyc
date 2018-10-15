package com.uporanges.evo;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentInfo {
	
	private String stu_email;
	private String stu_realname;
	private int stu_status;
	private String stu_qq;
	private String stu_school;
	private String stu_major;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date stu_graduationtime;
	private int stu_sex;
	private int stu_age;
	private String stu_address;
	private String stu_target_job;
	private Timestamp last_login_time;
	public StudentInfo() {}
	public StudentInfo(String stu_email, String stu_realname, int stu_status, String stu_qq, String stu_school,
			String stu_major, Date stu_graduationtime, int stu_sex, int stu_age, String stu_address,
			String stu_target_job, Timestamp last_login_time) {
		super();
		this.stu_email = stu_email;
		this.stu_realname = stu_realname;
		this.stu_status = stu_status;
		this.stu_qq = stu_qq;
		this.stu_school = stu_school;
		this.stu_major = stu_major;
		this.stu_graduationtime = stu_graduationtime;
		this.stu_sex = stu_sex;
		this.stu_age = stu_age;
		this.stu_address = stu_address;
		this.stu_target_job = stu_target_job;
		this.last_login_time = last_login_time;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getStu_realname() {
		return stu_realname;
	}
	public void setStu_realname(String stu_realname) {
		this.stu_realname = stu_realname;
	}
	public int getStu_status() {
		return stu_status;
	}
	public void setStu_status(int stu_status) {
		this.stu_status = stu_status;
	}
	public String getStu_qq() {
		return stu_qq;
	}
	public void setStu_qq(String stu_qq) {
		this.stu_qq = stu_qq;
	}
	public String getStu_school() {
		return stu_school;
	}
	public void setStu_school(String stu_school) {
		this.stu_school = stu_school;
	}
	public String getStu_major() {
		return stu_major;
	}
	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}
	public Date getStu_graduationtime() {
		return stu_graduationtime;
	}
	public void setStu_graduationtime(Date stu_graduationtime) {
		this.stu_graduationtime = stu_graduationtime;
	}
	public int getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(int stu_sex) {
		this.stu_sex = stu_sex;
	}
	public int getStu_age() {
		return stu_age;
	}
	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}
	public String getStu_address() {
		return stu_address;
	}
	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}
	public String getStu_target_job() {
		return stu_target_job;
	}
	public void setStu_target_job(String stu_target_job) {
		this.stu_target_job = stu_target_job;
	}
	public Timestamp getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}

}
