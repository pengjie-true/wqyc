package com.uporanges.controller.deal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uporanges.evo.BackJSON;

import com.uporanges.service.deal.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
  
	
	@Autowired
	CompanyService cs;
	//test
	@RequestMapping("test1")
	public int test() {
		return 111;
	}
	
	/**
	 * 获取该公司未回应的简历数量
	 * http://localhost:8080/qwyc/company/ResumenotbeingviewedSUM.shtml?user_id=1
	 * @param user_id
	 * @return
	 */

	@RequestMapping("ResumenotbeingviewedSUM")
	public BackJSON ResumenotbeingviewedSUM() {
		return cs.ResumenotbeingviewedSUM();
	}
	
	
	/**
	 * 将某学生的简历置为不被采纳  2 不采纳
	 */
	@RequestMapping("DisagreeResumeBydeliver_state")
	public BackJSON DisagreeResumeBydeliver_state(int send_resume_id) {
		return cs.ChanngeDeliver_stateByResume(send_resume_id,2);
	}
	/**
	 * 将某学生的简历置为被采纳 1代表简历被采纳 
	 */
	@RequestMapping("agreeResumeBydeliver_state")
	public BackJSON agreeResumeBydeliver_state(int send_resume_id) {
		return cs.ChanngeDeliver_stateByResume(send_resume_id,1);
	}
	
	/**
	 * 
	 * 获取该公司已经确认面试的人数
	 */
	@RequestMapping("getInterViewCountByCompany")
	public BackJSON getInterViewCountByCompany(int user_id) {
		return cs.getInterViewCountByCompany(user_id);
	}
	/**
	 * 
	 * 获取该公司已经确认面试的人
	 */
	@GetMapping("getInterViewByCompany")
	public BackJSON getInterViewByCompany(int user_id) {
		return cs.getInterViewByCompany(user_id);
	}
	
	/**
	 * 
	 * 获取该公司今日面试的人
	 */
	@GetMapping("getTodayIntervaerByTime")
	public BackJSON getTodayIntervaerByTime(int user_id,String interview_time) {
		return cs.getTodayIntervaerByTime(user_id,interview_time);
	}
	
	/**
	 * 
	 * 首页获取直接投递所有学生
	 */
	@GetMapping("getallOnePageGetStu")
	public BackJSON getallOnePageGetStu() {
		return cs.getallOnePageGetStu();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
