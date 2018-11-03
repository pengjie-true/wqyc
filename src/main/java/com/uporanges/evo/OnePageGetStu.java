package com.uporanges.evo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uporanges.entity.Code;

public class OnePageGetStu {
        private int user_id;
        private int send_resume_id;
        private String resume_name;
        private Code education_id1;
        private String resume_school;
        private Code resume_major1;
        private Code expect_job_id1;
        private int deliver_state;
    	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
        private Date resume_to_work_time;
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getSend_resume_id() {
			return send_resume_id;
		}
		public void setSend_resume_id(int send_resume_id) {
			this.send_resume_id = send_resume_id;
		}
		public String getResume_name() {
			return resume_name;
		}
		public void setResume_name(String resume_name) {
			this.resume_name = resume_name;
		}
		public Code getEducation_id1() {
			return education_id1;
		}
		public void setEducation_id1(Code education_id1) {
			this.education_id1 = education_id1;
		}
		public String getResume_school() {
			return resume_school;
		}
		public void setResume_school(String resume_school) {
			this.resume_school = resume_school;
		}
		public Code getResume_major1() {
			return resume_major1;
		}
		public void setResume_major1(Code resume_major1) {
			this.resume_major1 = resume_major1;
		}
		public Code getExpect_job_id1() {
			return expect_job_id1;
		}
		public void setExpect_job_id1(Code expect_job_id1) {
			this.expect_job_id1 = expect_job_id1;
		}
		public int getDeliver_state() {
			return deliver_state;
		}
		public void setDeliver_state(int deliver_state) {
			this.deliver_state = deliver_state;
		}
		public Date getResume_to_work_time() {
			return resume_to_work_time;
		}
		public void setResume_to_work_time(Date resume_to_work_time) {
			this.resume_to_work_time = resume_to_work_time;
		}
		public OnePageGetStu(int user_id, int send_resume_id, String resume_name, Code education_id1,
				String resume_school, Code resume_major1, Code expect_job_id1, int deliver_state,
				Date resume_to_work_time) {
			super();
			this.user_id = user_id;
			this.send_resume_id = send_resume_id;
			this.resume_name = resume_name;
			this.education_id1 = education_id1;
			this.resume_school = resume_school;
			this.resume_major1 = resume_major1;
			this.expect_job_id1 = expect_job_id1;
			this.deliver_state = deliver_state;
			this.resume_to_work_time = resume_to_work_time;
		}
		public OnePageGetStu() {
			super();
			// TODO Auto-generated constructor stub
		}
        
}
