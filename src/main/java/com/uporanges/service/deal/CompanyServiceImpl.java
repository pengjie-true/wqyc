package com.uporanges.service.deal;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uporanges.entity.IntervView;
import com.uporanges.evo.BackJSON;
import com.uporanges.mapper.deal.CompanyMapper;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyMapper companymapper;

	// 获取该公司未回应的简历数量
	public BackJSON ResumenotbeingviewedSUM() {
		BackJSON res = new BackJSON();
		res.setCode(200);
		res.setData(companymapper.ResumenotbeingviewedSUM());
		return res;
	}

	// 将某学生的简历置为不被采纳
	public BackJSON DisagreeResumeBydeliver_state(int user_id, int delivar_state) {
		BackJSON res = new BackJSON();
		int sum = companymapper.DisagreeResumeBydeliver_state(user_id, delivar_state);
		if (sum > 0) {
			res.setCode(200);
		} else
			res.setCode(400);
		res.setData(sum);
		System.out.println(sum);
		return res;
	}

	// 获取该公司已经确认面试的人数
	public BackJSON getInterViewCountByCompany(int user_id) {
		BackJSON res = new BackJSON();
		res.setCode(200);
		res.setData(companymapper.getInterViewCountByCompany(user_id));
		return res;
	}

	// 获取该公司已经确认面试的人
	public BackJSON getInterViewByCompany(int user_id) {
		BackJSON res = new BackJSON();
		res.setCode(200);

		List<Map<String, Object>> reslist = companymapper.getInterViewByCompany(user_id);
		for (Map<String, Object> map : reslist) {
			long student_id = (Long) map.get("student_id");
			map.put("student_name", companymapper.getUserById((int) student_id));
			map.remove("student_id");
		}
		res.setData(reslist);
		return res;
	}

	// 获取该公司今日面试的人
	public BackJSON getTodayIntervaerByTime(int user_id, String interview_time) {
		BackJSON res = new BackJSON();
		res.setCode(200);
		List<Map<String, Object>> reslist = companymapper.getTodayIntervaerByTime(user_id, interview_time);
		for (Map<String, Object> map : reslist) {
			long student_id = (Long) map.get("student_id");
			map.put("student_name", companymapper.getUserById((int) student_id));
			map.remove("student_id");
		}
		res.setData(reslist);
		return res;
	}

}
