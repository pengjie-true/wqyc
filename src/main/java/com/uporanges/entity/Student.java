package com.uporanges.entity;

import java.sql.Date;
import java.util.List;

public class Student {

	private User user;
	private String stu_email;
	private Date stu_createdtime;
	private String stu_realname;
	private int stu_status;
	private String stu_headPic;
	private String stu_qq;
	private String stu_school;
	private String stu_major;
	private Date stu_graduationtime;
	private int stu_sex;
	private int stu_age;
	private String stu_address;
	private int is_mobile_check;
	private String stu_target_job;
	private Date last_login_time;
	private StudentResume studentResume; 
	private List<StudentSendResume> studentSendResume;
	public Student() {}
	public Student(User user, String stu_email, Date stu_createdtime, String stu_realname, int stu_status,
			String stu_headPic, String stu_qq, String stu_school, String stu_major, Date stu_graduationtime,
			int stu_sex, int stu_age, String stu_address, int is_mobile_check, String stu_target_job,
			Date last_login_time, StudentResume studentResume, List<StudentSendResume> studentSendResume) {
		super();
		this.user = user;
		this.stu_email = stu_email;
		this.stu_createdtime = stu_createdtime;
		this.stu_realname = stu_realname;
		this.stu_status = stu_status;
		this.stu_headPic = stu_headPic;
		this.stu_qq = stu_qq;
		this.stu_school = stu_school;
		this.stu_major = stu_major;
		this.stu_graduationtime = stu_graduationtime;
		this.stu_sex = stu_sex;
		this.stu_age = stu_age;
		this.stu_address = stu_address;
		this.is_mobile_check = is_mobile_check;
		this.stu_target_job = stu_target_job;
		this.last_login_time = last_login_time;
		this.studentResume = studentResume;
		this.studentSendResume = studentSendResume;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public Date getStu_createdtime() {
		return stu_createdtime;
	}
	public void setStu_createdtime(Date stu_createdtime) {
		this.stu_createdtime = stu_createdtime;
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
	public String getStu_headPic() {
		return stu_headPic;
	}
	public void setStu_headPic(String stu_headPic) {
		this.stu_headPic = stu_headPic;
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
	public int getIs_mobile_check() {
		return is_mobile_check;
	}
	public void setIs_mobile_check(int is_mobile_check) {
		this.is_mobile_check = is_mobile_check;
	}
	public String getStu_target_job() {
		return stu_target_job;
	}
	public void setStu_target_job(String stu_target_job) {
		this.stu_target_job = stu_target_job;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public StudentResume getStudentResume() {
		return studentResume;
	}
	public void setStudentResume(StudentResume studentResume) {
		this.studentResume = studentResume;
	}
	public List<StudentSendResume> getStudentSendResume() {
		return studentSendResume;
	}
	public void setStudentSendResume(List<StudentSendResume> studentSendResume) {
		this.studentSendResume = studentSendResume;
	} 
	
}
