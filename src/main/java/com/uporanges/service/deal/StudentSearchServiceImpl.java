package com.uporanges.service.deal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uporanges.entity.CompanyJob;
import com.uporanges.evo.CompanyJobTeacher;
import com.uporanges.evo.CompanyMainInfo;
import com.uporanges.evo.JobInfo;
import com.uporanges.evo.JobMainInfo;
import com.uporanges.evo.TeacherCompany;
import com.uporanges.evo.TeacherMainInfo;
import com.uporanges.evo.TeacherOtherInfo;
import com.uporanges.mapper.deal.StudentSearchMapper;
import com.uporanges.util.Value;

@Service
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
public class StudentSearchServiceImpl implements StudentSearchService {
	
	@Autowired
	private StudentSearchMapper studentSearchMapper;
	
	public Map<String, Object> searchCompany(String key, int start) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<CompanyMainInfo> companys = studentSearchMapper.getCompanyMainInfobyKey(key, start, Value.getSearchcompanysize());
		if(companys.size()>0) {
			resultMap.put("data", companys);
			resultMap.put("start", start);
			resultMap.replace("code", 200);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countCompanyMainInfobyKey(key));
		} else
			resultMap.replace("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchCompany(String[] key, int start) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<Integer> companyIds = studentSearchMapper.getCompanyIdbyKey(key[0]);
		for(int i=1; i<key.length&&companyIds.size()>0; i++) 
			companyIds = studentSearchMapper.getCompanyIdbyKeyandId(key[i], companyIds);
		int count = companyIds.size();
		if(count==0) {
			resultMap.replace("code", 202);
			return resultMap;
		}
		resultMap.put("data", studentSearchMapper.getCompanyMainInfobyId(companyIds, start, Value.getSearchcompanysize()));
		resultMap.put("start", start);
		resultMap.put("count", count);
		resultMap.replace("code", 200);
		return resultMap;
	}
	public Map<String, Object> searchCompany(int start) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<CompanyMainInfo> companys = studentSearchMapper.getCompanyInfo(start, Value.getSearchcompanysize());
		if(companys.size()>0) {
			resultMap.put("data", companys);
			resultMap.put("start", start);
			resultMap.replace("code", 200);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countCompanyInfo());
		} else
			resultMap.replace("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> companyDetailInfo(int user_id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		CompanyJobTeacher cjt = studentSearchMapper.companyDetailInfo(user_id);
		if(cjt!=null) {
			resultMap.put("companyInfo", cjt);
			resultMap.put("job_tatal", studentSearchMapper.countCompanyJob(user_id));
			resultMap.put("teacher_total", studentSearchMapper.countCompanyTeacher(user_id));
			//这里设置第一次查询结束位置为3，后期可改
			resultMap.put("job_start", 3);
			resultMap.put("teacher_start", 3);
			resultMap.put("code", 200);
		} else
			resultMap.put("code", 400);
		return resultMap;
	}
	public Map<String, Object> companyMoreJob(int user_id, int job_start, int job_size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<CompanyJob> job = studentSearchMapper.companyMoreJob(user_id, job_start, job_size);
		job_size = job.size();
		if(job_size>0) {
			resultMap.put("data", job);
			resultMap.put("code", 200);
			resultMap.put("job_start", job_start+job_size);
		} else 
			resultMap.put("code", 202);
		return resultMap;
	}
	public Map<String, Object> companyMoreTeacher(int user_id, int teacher_start, int teacher_size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<TeacherMainInfo> teacher = studentSearchMapper.companyMoreTeacher(user_id, teacher_start, teacher_size);
		teacher_size = teacher.size();
		if(teacher_size>0) {
			resultMap.put("data", teacher);
			resultMap.put("teacher_start", teacher_start+teacher_size);
			resultMap.put("code", 200);
		} else 
			resultMap.put("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> teacherDetailInfo(int teacher_id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		TeacherOtherInfo teacher = studentSearchMapper.teacherDetailInfo(teacher_id);
		if(teacher!=null) {
			resultMap.put("data", teacher);
			resultMap.put("company_start", 3);
			resultMap.put("company_total", studentSearchMapper.countTeacherCompany(teacher_id));
			resultMap.put("code", 200);
		} else
			resultMap.put("code", 202);
		return resultMap;
	}
	public Map<String, Object> teacherMoreCompany(int teacher_id, int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<TeacherCompany> company = studentSearchMapper.teacherMoreCompany(teacher_id, start, size);
		size = company.size();
		if(size>0) {
			resultMap.put("data", company);
			resultMap.put("company_start", start+size);
			resultMap.put("code", 200);
		} else 
			resultMap.put("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchJob(int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<JobInfo> job = studentSearchMapper.searchJob(start, size);
		size = job.size();
		if(size>0) {
			resultMap.put("data", job);
			resultMap.put("start", start+size);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countJob());
			resultMap.replace("code", 200);
		} else
			resultMap.replace("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchJob(String key, int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<JobInfo> job = studentSearchMapper.searchJobbyKey(key, start, size);
		size = job.size();
		if(size>0) {
			resultMap.put("data", job);
			resultMap.put("start", start+size);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countJobbyKey(key));
			resultMap.put("code", 200);
		} else
			resultMap.put("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchJob(String[] key, int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<Integer> job_id = studentSearchMapper.searchJobId(key[0]);
		for(int i=1; i<key.length&&job_id.size()>0; i++)
			job_id = studentSearchMapper.searchJobIdbyId(job_id, key[i]);
		int idSize = job_id.size();
		if(idSize>0) {
			List<JobInfo> jobInfo = studentSearchMapper.searchJobbyId(job_id, start, size);
			resultMap.put("data", jobInfo);
			resultMap.put("start", start+jobInfo.size());
			if(start==0)
				resultMap.put("total", idSize);
			resultMap.replace("code", 200);
		} else
			resultMap.replace("code", 200);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchCompanybySelect(int job_id, int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<JobMainInfo> job = studentSearchMapper.searchCompanybySelect(job_id, start, size);
		size = job.size();
		if(size>0) {
			resultMap.put("data", job);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countJobbyId(job_id));
			resultMap.put("start", start+size);
			resultMap.put("code", 200);
		} else
			resultMap.put("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchTeacher(int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<TeacherMainInfo> teacher = studentSearchMapper.searchTeacher(start, size);
		size = teacher.size();
		if(size>0) {
			resultMap.put("data", teacher);
			resultMap.put("start", start+size);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countTeacher());
			resultMap.replace("code", 200);
		} else
			resultMap.replace("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchTeacher(String key, int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<TeacherMainInfo> teacher = studentSearchMapper.searchTeacherbyKey(key, start, size);
		size = teacher.size();
		if(size>0) {
			resultMap.put("data", teacher);
			resultMap.put("start", start+size);
			if(start==0)
				resultMap.put("total", studentSearchMapper.countTeacherbyKey(key));
			resultMap.replace("code", 200);
		} else
			resultMap.replace("code", 202);
		return resultMap;
	}
	@Transactional(readOnly=true)
	public Map<String, Object> searchTeacher(String[] key, int start, int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 400);
		List<Integer> user_ids = studentSearchMapper.searchTeacherIdbyKey(key[0]);
		for(int i=1; i<key.length&&user_ids.size()>0; i++)
			user_ids = studentSearchMapper.searchTeacherIdbyKeyId(key[i], user_ids);
		int idSize = user_ids.size();
		if(idSize>0) {
			List<TeacherMainInfo> teacher = studentSearchMapper.searchTeacherbyId(user_ids, start, size);
			size = teacher.size();
			if(size>0) {
				resultMap.put("data", teacher);
				resultMap.put("start", start+idSize);
				if(start==0)
					resultMap.put("total", idSize);
				resultMap.replace("code", 200);
			} else
				resultMap.replace("code", 202);
		} else 
			resultMap.replace("code", 202);
		return resultMap;
	}

}
