package com.uporanges.service.deal;



import com.uporanges.evo.BackJSON;

public interface CompanyService {

	// 获取该公司未回应的简历数量
	BackJSON ResumenotbeingviewedSUM();

	// 将某学生的简历置为不被采纳
	BackJSON DisagreeResumeBydeliver_state(int user_id, int delivar_state);

	// 获取该公司已经确认面试的人数
	BackJSON getInterViewCountByCompany(int user_id);

	// 获取该公司已经确认面试的人
	BackJSON getInterViewByCompany(int user_id);

	// 获取该公司今日面试的人
	BackJSON getTodayIntervaerByTime(int user_id, String interview_time);
}
