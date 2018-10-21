package com.uporanges.controller.company;

import java.util.Date;

import org.apache.poi.hssf.util.HSSFColor.INDIGO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uporanges.entity.t_company;
import com.uporanges.entity.t_company_job;
import com.uporanges.entity.t_company_verify_teacher;
import com.uporanges.evo.BackJSON;
import com.uporanges.service.company.CompanyService;

@Controller
@RequestMapping(value = "/company/")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	/**
	 * PJ 10.20
	 * @param user_Id
	 * 查看公司信息
	 */
	@RequestMapping(value = "getCompanyInfo")
	@ResponseBody
	public BackJSON getCompanyInfo(int userId) {
		return companyService.getCompanyInfo(userId);
	}
	
	/**
	 * PJ 10.20
	 * @param company
	 * 修改公司信息(支持动态修改)
	 */
	@RequestMapping(value = "updateByPrimaryKey")
	@ResponseBody
	public BackJSON updateByPrimaryKey(t_company company,Integer userId) {
		company.setUserId(userId);
		return companyService.updateByPrimaryKeySelective(company);
	}
	
	/**
	 * PJ 10.20
	 * @param company
	 * @插入新增公司信息
	 */
	@RequestMapping(value = "insert")
	@ResponseBody
	public BackJSON insert(t_company company) {
		//t_company company1 = new t_company();
//		company1.setUserId(2);
//		company1.setCompanyAddress("bbb");
//		company1.setCompanyBrief("bbb");
//		company1.setCompanyBusinessLicense("bbb");
//		company1.setCompanyEmail("bbb");
//		company1.setCompanyLegalPerson("bbb");
//		company1.setCompanyLogoPic("bbb");
//		company1.setCompanyNature("bbb");
//		
//		company1.setCompanyPhone1("bbb");
//		company1.setCompanyPhone2("bbb");
//		
//		company1.setCompanyRealname("bbb");
//		company1.setCompanyTrade("bbb");
//		Date date = new Date();
		Date date = new Date();
		company.setCreateTime(date);
//		company1.setCreateTime(date);
//		company1.setLegalPersonCardId("bbb");
		return companyService.insert(company);
		
		
	}
	/**
	 * PJ 10.20
	 * @param companyName
	 * 查询公司职位信息
	 */
	@RequestMapping(value = "lookPositionInfo")
	@ResponseBody
	public BackJSON lookPositionInfo(String companyName,Integer jobId) {
		return companyService.lookPosition(companyName, jobId);
		
	}
	
	/**
	 * PJ 10.20
	 * @param companyName
	 * @param jobId
	 * @param companyJob
	 * 修改公司职位信息
	 */
	@RequestMapping(value = "updatePositionInfo")
	@ResponseBody
	public BackJSON updatePositionInfo(String companyName,Integer jobId,t_company_job companyJob) {
//		t_company_job companyJob = new t_company_job();
//		companyJob.setJobDescribe("ddd");
		return companyService.updatePosition(companyName,jobId,companyJob);
	}
	
	/**
	 * PJ 10.20
	 * @param companyJob
	 * @添加公司职位信息
	 */
	@RequestMapping(value = "addPositionInfo")
	@ResponseBody
	public BackJSON addPositionInfo(t_company_job companyJob) {
//		t_company_job companyJob = new t_company_job();
//		companyJob.setCompanyId(2L);
//		companyJob.setJobId(2);
//		companyJob.setJobDescribe("aaa");
//		companyJob.setJobSalary("8000");
		return companyService.addPositionInfo(companyJob);
	}
	/**
	 * PJ 10.21
	 * @param companyVerifyTeacher
	 * @公司审核申请老师加入(审核可以解约)
	 */
	@RequestMapping(value = "auditTeacherJoining")
	@ResponseBody
	public BackJSON auditTeacherJoining(t_company_verify_teacher companyVerifyTeacher) {
//		t_company_verify_teacher companyVerifyTeacher = new t_company_verify_teacher();
//		companyVerifyTeacher.setCompanyId(1);
//		companyVerifyTeacher.setTeacherId(1);
//		companyVerifyTeacher.setVerifyState(1);
		Date date = new Date();
		companyVerifyTeacher.setVerifyTime(date);
		return companyService.auditTeacherJoining(companyVerifyTeacher);
	}
	
	/**
	 * PJ 10.21
	 * @param companyId
	 * @公司查看教师
	 */
	@RequestMapping(value = "viewCooperativeTeachers")
	@ResponseBody
	public BackJSON viewCooperativeTeachers(Integer companyId) {
		return companyService.viewCooperativeTeachers(companyId);
	}
	/**
	 * PJ 10.21
	 * @param companyId
	 * @公司查看学生简历
	 */
	@RequestMapping(value = "viewStudentResume")
	@ResponseBody
	public BackJSON viewStudentResume(Integer companyId) {
		return companyService.viewStudentResume(companyId);
	}
	/**
	 * PJ 10.21
	 * @param sendResumeId
	 * @param delivarState
	 * @公司审核学生简历
	 */
	@RequestMapping(value = "reviewingStudentResumes")
	@ResponseBody
	public BackJSON reviewingStudentResumes(Integer sendResumeId, Integer delivarState) {
		return companyService.reviewingStudentResumes(sendResumeId, delivarState);
	}
}
