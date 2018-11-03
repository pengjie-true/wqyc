package com.uporanges.service.deal;




import com.uporanges.evo.BackJSON;


public interface CompanyService {

	// 获取该公司未回应的简历数量
	BackJSON ResumenotbeingviewedSUM();

	// 将某学生的简历置为： 0代表未查看 1代表简历被采纳 2 不采纳
	BackJSON ChanngeDeliver_stateByResume(int send_resume_id, int delivar_state);

	// 获取该公司已经确认面试的人数
	BackJSON getInterViewCountByCompany(int user_id);

	// 获取该公司已经确认面试的人
	BackJSON getInterViewByCompany(int user_id);

	// 获取该公司今日面试的人
	BackJSON getTodayIntervaerByTime(int user_id, String interview_time);
	// 首页获取直接投递所有学生
	BackJSON getallOnePageGetStu();
}
