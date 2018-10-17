package com.uporanges.evo;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TStudentSendResume {
	
	private Integer send_resume_id;
	private Integer user_id;
	private Integer resume_id;
	private Integer company_id;
	private Integer expect_job_id1;
	private Integer expect_job_id2;
	private String resume_expect_workplace1;
	private String resume_expect_workplace2;
	private Integer resume_expect_salary;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date resume_to_work_time;
	private Integer delivar_state;
	private Timestamp deliver_time;
	public TStudentSendResume() {}
	public TStudentSendResume(Integer send_resume_id, Integer user_id, Integer resume_id, Integer company_id,
			Integer expect_job_id1, Integer expect_job_id2, String resume_expect_workplace1,
			String resume_expect_workplace2, Integer resume_expect_salary, Date resume_to_work_time,
			Integer delivar_state, Timestamp deliver_time) {
		super();
		this.send_resume_id = send_resume_id;
		this.user_id = user_id;
		this.resume_id = resume_id;
		this.company_id = company_id;
		this.expect_job_id1 = expect_job_id1;
		this.expect_job_id2 = expect_job_id2;
		this.resume_expect_workplace1 = resume_expect_workplace1;
		this.resume_expect_workplace2 = resume_expect_workplace2;
		this.resume_expect_salary = resume_expect_salary;
		this.resume_to_work_time = resume_to_work_time;
		this.delivar_state = delivar_state;
		this.deliver_time = deliver_time;
	}
	public Integer getSend_resume_id() {
		return send_resume_id;
	}
	public void setSend_resume_id(Integer send_resume_id) {
		this.send_resume_id = send_resume_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getResume_id() {
		return resume_id;
	}
	public void setResume_id(Integer resume_id) {
		this.resume_id = resume_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getExpect_job_id1() {
		return expect_job_id1;
	}
	public void setExpect_job_id1(Integer expect_job_id1) {
		this.expect_job_id1 = expect_job_id1;
	}
	public Integer getExpect_job_id2() {
		return expect_job_id2;
	}
	public void setExpect_job_id2(Integer expect_job_id2) {
		this.expect_job_id2 = expect_job_id2;
	}
	public String getResume_expect_workplace1() {
		return resume_expect_workplace1;
	}
	public void setResume_expect_workplace1(String resume_expect_workplace1) {
		this.resume_expect_workplace1 = resume_expect_workplace1;
	}
	public String getResume_expect_workplace2() {
		return resume_expect_workplace2;
	}
	public void setResume_expect_workplace2(String resume_expect_workplace2) {
		this.resume_expect_workplace2 = resume_expect_workplace2;
	}
	public Integer getResume_expect_salary() {
		return resume_expect_salary;
	}
	public void setResume_expect_salary(Integer resume_expect_salary) {
		this.resume_expect_salary = resume_expect_salary;
	}
	public Date getResume_to_work_time() {
		return resume_to_work_time;
	}
	public void setResume_to_work_time(Date resume_to_work_time) {
		this.resume_to_work_time = resume_to_work_time;
	}
	public Integer getDelivar_state() {
		return delivar_state;
	}
	public void setDelivar_state(Integer delivar_state) {
		this.delivar_state = delivar_state;
	}
	public Timestamp getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(Timestamp deliver_time) {
		this.deliver_time = deliver_time;
	}

}
