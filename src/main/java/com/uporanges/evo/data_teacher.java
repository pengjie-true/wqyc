package com.uporanges.evo;

import java.util.Date;

public class data_teacher {
    private int recommend_id;
    private int teacher_id;
    private int student_id;
    public data_teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer send_resume_id;
    private int company_id;
    private int recommend_describe;
    private Date recommend_time;
	public int getRecommend_id() {
		return recommend_id;
	}
	public void setRecommend_id(int recommend_id) {
		this.recommend_id = recommend_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public Integer getSend_resume_id() {
		return send_resume_id;
	}
	public void setSend_resume_id(Integer send_resume_id) {
		this.send_resume_id = send_resume_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getRecommend_describe() {
		return recommend_describe;
	}
	public void setRecommend_describe(int recommend_describe) {
		this.recommend_describe = recommend_describe;
	}
	public Date getRecommend_time() {
		return recommend_time;
	}
	public void setRecommend_time(Date recommend_time) {
		this.recommend_time = recommend_time;
	}
}