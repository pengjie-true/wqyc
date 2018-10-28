package com.uporanges.mapper.deal;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;




public interface CompanyMapper {
	@Select("select COUNT(*) FROM t_student_send_resume WHERE delivar_state =0")
	int ResumenotbeingviewedSUM();
	
	
	@Update("UPDATE t_student_send_resume SET delivar_state=2 WHERE delivar_state = #{arg1} AND user_id=#{arg0}")
	int DisagreeResumeBydeliver_state(int user_id,int delivar_state);
	
	@Select("select COUNT(*) from t_interview WHERE user_id=#{arg0}")
	 int getInterViewCountByCompany(int user_id);
	
	@Select("select * from t_interview where user_id=#{arg0}")
	List<Map<String, Object>> getInterViewByCompany(int user_id);
	
	@Select ("select user_name from t_user where user_id=#{arg0}")
	 String getUserById(int user_id);
	
	@Select ("select * from t_interview WHERE user_id = #{arg0} AND interview_time like '${arg1}%'")
	List<Map<String, Object>> getTodayIntervaerByTime(int user_id, String interview_time);
}
