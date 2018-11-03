package com.uporanges.mapper.deal;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.uporanges.entity.Code;

import com.uporanges.evo.OnePageGetStu;




public interface CompanyMapper {
	@Select("select COUNT(*) FROM t_student_send_resume WHERE delivar_state =0")
	int ResumenotbeingviewedSUM();
	
	
	@Update("UPDATE t_student_send_resume SET delivar_state=#{arg1} WHERE send_resume_id=#{arg0}")
	int ChanngeDeliver_stateByResume(int send_resume_id,int delivar_state);
	
	@Select("select COUNT(*) from t_interview WHERE user_id=#{arg0}")
	 int getInterViewCountByCompany(int user_id);
	
	@Select("select * from t_interview where user_id=#{arg0}")
	List<Map<String, Object>> getInterViewByCompany(int user_id);
	
	@Select ("select user_name from t_user where user_id=#{arg0}")
	 String getUserById(int user_id);
	
	@Select ("select * from t_interview WHERE user_id = #{arg0} AND interview_time like '${arg1}%'")
	List<Map<String, Object>> getTodayIntervaerByTime(int user_id, String interview_time);
	
	@Select("select * FROM onepagegetstu WHERE delivar_state=0")
	@Results({

		@Result(property="resume_to_work_time", column="resume_to_work_time"),
		@Result(property="user_id", column="user_id"),
		@Result(property="send_resume_id", column="send_resume_id"),
		@Result(property="resume_name", column="resume_name"),
		@Result(property="education_id1", column="education_id1", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="resume_school", column="resume_school"),
		@Result(property="resume_major1", column="resume_major1", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="expect_job_id1", column="expect_job_id1", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="deliver_state", column="deliver_state")
	})
	List<OnePageGetStu> getallOnePageGetStu();
	
	@Select("select  * FROM t_code WHERE code_id=#{arg0}")
	Code getCodebyId(Integer code_id);
	
}
