package com.uporanges.service.deal;

import java.util.Map;

public interface StudentSearchService {

	//学生搜索公司（没输入关键字），直接按顺序返回所有公司
	public Map<String, Object> searchCompany(int start);
	//学生搜索公司（单关键字），根据关键字搜索。返回符合条件的公司。
	public Map<String, Object> searchCompany(String key, int start);
	//学生搜索公司（多关键字）（模糊搜索）先按第一个关键字搜索，再根据第二个关键字从第一个关键字里筛选，以此类推。
	public Map<String, Object> searchCompany(String[] key, int start);
	//查看公司详细信息
	public Map<String, Object> companyDetailInfo(int user_id);
	//学生查询更多该公司提供的岗位
	public Map<String, Object> companyMoreJob(int user_id, int job_start, int job_size);
	//学生查询更多与该公司合作老师
	public Map<String, Object> companyMoreTeacher(int user_id, int teacher_start, int teacher_size);
	//根据teacher_id查询老师详细信息
	public Map<String, Object> teacherDetailInfo(int teacher_id);
	//学生查看更多与老师合作的公司
	public Map<String, Object> teacherMoreCompany(int teacher_id, int start, int size);
	//学生浏览岗位（没输入关键字）
	public Map<String, Object> searchJob(int start, int size);
	//学生浏览岗位（输入一个关键字）
	public Map<String, Object> searchJob(String key, int start, int size);
	//学生浏览岗位（输入多个关键字）
	public Map<String, Object> searchJob(String[] key, int start, int size);
	//学生浏览岗位（通过选择job_id）
	public Map<String, Object> searchCompanybySelect(int job_id, int start, int size);
	//学生浏览老师（无关键字）
	public Map<String, Object> searchTeacher(int start, int size);
	//学生浏览老师（一个关键字）
	public Map<String, Object> searchTeacher(String key, int start, int size);
	//学生浏览老师（多个关键字）
	public Map<String, Object> searchTeacher(String[] key, int start, int size);
	
}
