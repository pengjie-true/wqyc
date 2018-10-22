package com.uporanges.evo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StuCollectJobT {

	private Integer user_id;
	private Integer job_id;
	private Integer company_id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp collect_time;
	public StuCollectJobT() {}
	public StuCollectJobT(Integer user_id, Integer job_id, Integer company_id, Timestamp collect_time) {
		super();
		this.user_id = user_id;
		this.job_id = job_id;
		this.company_id = company_id;
		this.collect_time = collect_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Timestamp getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(Timestamp collect_time) {
		this.collect_time = collect_time;
	}
	
}
