package com.uporanges.mapper.deal;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import com.uporanges.entity.Code;
import com.uporanges.entity.CompanyJob;
import com.uporanges.entity.Job;
import com.uporanges.evo.CompanyJobTeacher;
import com.uporanges.evo.CompanyMainInfo;
import com.uporanges.evo.JobCompany;
import com.uporanges.evo.JobCompanyInfo;
import com.uporanges.evo.JobInfo;
import com.uporanges.evo.JobMainInfo;
import com.uporanges.evo.TeacherCompany;
import com.uporanges.evo.TeacherMainInfo;
import com.uporanges.evo.TeacherOtherInfo;
import com.uporanges.evo.UserInfo;

public interface StudentSearchMapper {

	@Select("select user_id, company_realname, company_trade, company_nature, company_address, company_logo_pic, company_brief "
			+ "from t_company limit ${start}, ${size}")
	@Results({
		@Result(property="user", column="user_id", javaType=UserInfo.class,
		one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	List<CompanyMainInfo> getCompanyInfo(@Param("start")int start, @Param("size")int size);
	
	@Select("select count(user_id) from t_company")
	int countCompanyInfo();
	
	@Select("select user_id from t_company where company_realname like \"%\"#{key}\"%\" or company_trade like \"%\"#{key}\"%\" "
			+ "or company_nature like \"%\"#{key}\"%\" or company_address like \"%\"#{key}\"%\" or company_legal_person like \"%\"#{key}\"%\"")
	List<Integer> getCompanyIdbyKey(String key);
	
	@Select("<script>"
			+ "select user_id from t_company "
			+ "<where>"
			+ "user_id in "
			+ "<foreach collection='companyId' item='item' index='index' open='(' separator=',' close=')'>"
			+ "#{item}"
			+ "</foreach>"
			+ "and (company_realname like \"%\"#{key}\"%\" or company_trade like \"%\"#{key}\"%\" or "
			+ "company_nature like \"%\"#{key}\"%\" or company_address like \"%\"#{key}\"%\" or company_legal_person like \"%\"#{key}\"%\") "
			+ "</where>"
			+ "</script>")
	@Results({
		@Result(id=true, property="user_id", column="user_id")
	})
	List<Integer> getCompanyIdbyKeyandId(@Param("key") String key, @Param("companyId")List<Integer> companyId);
	
	@SelectProvider(type=StudentProvider.class, method="getCompanyMainInfobyId")
	@Results({
		@Result(id=true, property="user", column="user_id", javaType=UserInfo.class,
				one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	List<CompanyMainInfo> getCompanyMainInfobyId(List<Integer> companyId, int start, int size);
	
	@Select("select user_id, company_realname, company_trade, company_nature, company_address, company_logo_pic, company_brief "
			+ "from t_company where company_realname like CONCAT('%', #{arg0}, '%') "
			+ "or company_trade like CONCAT('%', #{arg0}, '%') or company_nature like CONCAT('%', #{arg0}, '%') "
			+ "or company_address like CONCAT('%', #{arg0}, '%') or company_legal_person like CONCAT('%', #{arg0}, '%') "
			+ "limit #{arg1}, #{arg2}")
	@Results({
		@Result(id=true, property="user", column="user_id", javaType=UserInfo.class,
		one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	List<CompanyMainInfo> getCompanyMainInfobyKey(String key, int start, int size);
	
	@Select("select count(user_id) from t_company where company_realname like CONCAT('%', #{arg0}, '%') " + 
			"or company_trade like CONCAT('%', #{arg0}, '%') or company_nature like CONCAT('%', #{arg0}, '%') " + 
			"or company_address like CONCAT('%', #{arg0}, '%') or company_legal_person like CONCAT('%', #{arg0}, '%')")
	int countCompanyMainInfobyKey(String key);
	
	@Select("select user_id, user_name from t_user where user_id = ${_parameter}")
	UserInfo getUserbyId(Integer user_id);
	
	@Select("select * from t_company where user_id = ${_parameter}")
	@Results({
		@Result(property="create_time", column="create_time", jdbcType=JdbcType.DATE),
		@Result(id=true, property="userInfo", column="user_id", javaType=UserInfo.class,
				one=@One(select="getUserbyId", fetchType=FetchType.EAGER)),
		@Result(property="companyJob", column="user_id", javaType=List.class, 
				many=@Many(select="getCompanyJobbyId", fetchType=FetchType.EAGER)),
		@Result(property="companyTeacher", column="user_id", javaType=List.class, 
				many=@Many(select="getCompanyTeacherbyId", fetchType=FetchType.EAGER))
	})
	CompanyJobTeacher companyDetailInfo(int user_id);
	
	//默认第一次返回3条岗位信息
	@Select("select * from t_company_job where company_id = ${_parameter} limit 0, 3")
	@Results({
		@Result(property="job_describe", column="job_describe"),
		@Result(property="job_salary", column="job_salary"),
		@Result(property="job", column="job_id", javaType=Job.class,
				one=@One(select="getJobInfobyId", fetchType=FetchType.EAGER))
	})
	List<CompanyJob> getCompanyJobbyId(int user_id);
	
	@Select("select * from t_job where job_id = ${_parameter}")
	Job getJobInfobyId(int job_id);
	
	@Select("select count(1) from t_company_job where company_id = #{companyId}")
	int countCompanyJob(int companyId);
	
	//默认第一次查询公司的3条老师信息
	@Select("select t.user_id, t.teacher_name, t.teacher_hometown, t.teacher_sex, t.teacher_workschool, "
			+ "t.teacher_major1, t.teacher_major2, t.teacher_title, t.teacher_post, t.teacher_teach_state "
			+ "from t_teacher t where t.user_id in "
			+ "(select cvt.teacher_id from t_company_verify_teacher cvt where cvt.company_id = ${_parameter} "
			+ "and cvt.verify_state = 1) limit 0, 3")
	@Results({
		@Result(property="userInfo", column="user_id", javaType=UserInfo.class,
				one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	List<TeacherMainInfo> getCompanyTeacherbyId(int user_id);
	
	@Select("select count(1) from t_company_verify_teacher where company_id = #{companyId} and verify_state = 1")
	int countCompanyTeacher(int companyId);
	
	@Select("select * from t_company_job where company_id=#{param1} limit #{param2}, #{param3}")
	@Results({
		@Result(property="job_describe", column="job_describe"),
		@Result(property="job_salary", column="job_salary"),
		@Result(property="job", column="job_id", javaType=Job.class, 
				one=@One(select="getJobInfobyId", fetchType=FetchType.EAGER))
	})
	List<CompanyJob> companyMoreJob(int company_id, int start, int size);
	
	@Select("select t.user_id, t.teacher_name, t.teacher_hometown, t.teacher_sex, t.teacher_workschool, "
			+ "t.teacher_major1, t.teacher_major2, t.teacher_title, t.teacher_post, t.teacher_teach_state "
			+ "from t_teacher t where t.user_id in "
			+ "(select cvt.teacher_id from t_company_verify_teacher cvt where cvt.company_id = #{param1} "
			+ "and cvt.verify_state = 1) limit #{param2}, #{param3}")
	@Results({
		@Result(property="userInfo", column="user_id", javaType=UserInfo.class,
				one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	List<TeacherMainInfo> companyMoreTeacher(int user_id, int start, int size);
	
	@Select("select user_id, teacher_birthday, teacher_email, teacher_WeChat, teacher_hometown, teacher_sex, teacher_education1, "
			+ "teacher_education2, teacher_achievements, teacher_work_describe from t_teacher where user_id = ${_parameter}")
	@Results({
		@Result(property="teacher_birthday", column="teacher_birthday", jdbcType=JdbcType.DATE),
		@Result(id=true, property="userInfo", column="user_id", javaType=UserInfo.class,
				one=@One(select="getUserInfobyId", fetchType=FetchType.EAGER)),
		@Result(property="teacher_education1", column="teacher_education1", javaType=Code.class, jdbcType=JdbcType.INTEGER,
				one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="teacher_education2", column="teacher_education2", javaType=Code.class, jdbcType=JdbcType.INTEGER,
				one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="teacherCompany", column="user_id", javaType=List.class,
				many=@Many(select="getTeacherCompany", fetchType=FetchType.EAGER))
	}) 
	TeacherOtherInfo teacherDetailInfo(int teacher_id);
	
	@Select("select user_id, user_name, user_phone, user_pic from t_user where user_id = ${_parameter}")
	UserInfo getUserInfobyId(Integer user_id);
	
	@Select("select c.user_id, c.company_realname, c.company_trade, c.company_address, c.company_logo_pic from t_company c "
			+ "where c.user_id in (select cvt.company_id from t_company_verify_teacher cvt "
			+ "where cvt.teacher_id = #{teacher_id} and cvt.verify_state = 1) limit 0, 3")
	@Results({
		@Result(id=true, property="company_id", column="user_id")
	})
	List<TeacherCompany> getTeacherCompany(Integer teacher_id);
	
	@Select("select c.user_id, c.company_realname, c.company_trade, c.company_address, c.company_logo_pic from t_company c "
			+ "where c.user_id in (select cvt.company_id from t_company_verify_teacher cvt "
			+ "where cvt.teacher_id = #{arg0} and cvt.verify_state = 1) limit #{arg1}, #{arg2}")
	@Results({
		@Result(id=true, property="company_id", column="user_id")
	})
	List<TeacherCompany> teacherMoreCompany(int teacher_id, int start, int size);
	
	@Select("select count(1) from t_company_verify_teacher where teacher_id = #{teacher_id} and verify_state = 1")
	int countTeacherCompany(int teacher_id);
	
	@Select("select * from t_job limit #{arg0}, #{arg1}")
	@Results({
		@Result(id=true, property="job_id", column="job_id"),
		@Result(property="jobCompany", column="job_id", javaType=List.class,
				many=@Many(select="getJobCompanybyId", fetchType=FetchType.EAGER))
	})
	List<JobInfo> searchJob(int start, int size);
	
	@Select("select company_id, job_describe, job_salary from t_company_job where job_id=${_parameter}")
	@Results({
		@Result(property="jobCompanyInfo", column="company_id", javaType=JobCompanyInfo.class, 
				one=@One(select="getJobCompanyInfobyId", fetchType=FetchType.EAGER))
	})
	List<JobCompany> getJobCompanybyId(int job_id);
	
	@Select("select user_id, company_realname, company_address from t_company where user_id=${_parameter}")
	@Results({
		@Result(id=true, property="userInfo", column="user_id", javaType=UserInfo.class, 
				one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	JobCompanyInfo getJobCompanyInfobyId(int company_id);
	
	@Select("select count(job_id) from t_job")
	int countJob();
	
	@Select("select * from t_job where job_name like CONCAT('%', #{key}, '%') or job_type like CONCAT('%', #{key}, '%') limit #{start}, #{size}")
	@Results({
		@Result(id=true, property="job_id", column="job_id"),
		@Result(property="jobCompany", column="job_id", javaType=List.class,
				many=@Many(select="getJobCompanybyId", fetchType=FetchType.EAGER))
	})
	List<JobInfo> searchJobbyKey(@Param("key")String key, @Param("start")int start, @Param("size")int size);
	
	@Select("select count(job_id) from t_job where job_name like CONCAT('%', #{key}, '%') or job_type like CONCAT('%', #{key}, '%')")
	int countJobbyKey(String key);
	
	@Select("select job_id from t_job where job_name like CONCAT('%', #{key}, '%') or job_type like CONCAT('%', #{key}, '%')")
	List<Integer> searchJobId(@Param("key")String key);
	
	@Select("<script>"
			+ "select job_id from t_job where job_id in "
			+ "<foreach collection='job_ids' item='job_id' index='index' open='(' separator=',' close=')'>"
			+ "#{job_id}"
			+ "</foreach>"
			+ " and (job_name like CONCAT('%', #{key}, '%') or job_type like CONCAT('%', #{key}, '%'))"
			+ "</script>")
	List<Integer> searchJobIdbyId(@Param("job_ids")List<Integer> job_ids, @Param("key")String key);
	
	@SelectProvider(type=StudentProvider.class, method="searchJobbyId")
	@Results({
		@Result(id=true, property="job_id", column="job_id"),
		@Result(property="jobCompany", column="job_id", javaType=List.class,
				many=@Many(select="getJobCompanybyId", fetchType=FetchType.EAGER))
	})
	List<JobInfo> searchJobbyId(List<Integer> job_ids, int start, int size);
	
	@SelectProvider(type=StudentProvider.class, method="searchCompanybySelect")
	List<JobMainInfo> searchCompanybySelect(int job_id, int start, int size);
	
	@Select("select count(job_id) from t_job where job_id = ${_parameter}")
	int countJobbyId(Integer job_id);

	@Select("select user_id, teacher_name, teacher_hometown, teacher_sex, teacher_workschool, teacher_major1, teacher_major2, "
			+ "teacher_title, teacher_post, teacher_teach_state from t_teacher limit #{param1}, #{param2}")
	@Results({
		@Result(id=true, property="userInfo", column="user_id", javaType=UserInfo.class, 
				one=@One(select="getUserInfobyId", fetchType=FetchType.EAGER))
	})
	List<TeacherMainInfo> searchTeacher(int start, int size);
	
	
	@Select("select count(user_id) from t_teacher")
	int countTeacher(); 
	
	@Select("select user_id, teacher_name, teacher_hometown, teacher_sex, teacher_workschool, teacher_major1, teacher_major2, " + 
			"teacher_title, teacher_post, teacher_teach_state from t_teacher where "
			+ "teacher_name LIKE CONCAT('%', #{key}, '%') or teacher_title LIKE CONCAT('%', #{key}, '%') or "
			+ "teacher_post LIKE CONCAT('%', #{key}, '%') or teacher_hometown LIKE CONCAT('%', #{key}, '%') or "
			+ "teacher_major1 LIKE CONCAT('%', #{key}, '%') or teacher_major2 LIKE CONCAT('%', #{key}, '%') or "
			+ "teacher_workschool LIKE CONCAT('%', #{key}, '%') or teacher_sex LIKE CONCAT('%', #{key}, '%') "
			+ "limit #{start}, #{size}")
	@Results({
		@Result(id=true, property="userInfo", column="user_id", javaType=UserInfo.class, 
				one=@One(select="getUserInfobyId", fetchType=FetchType.EAGER))
	})
	List<TeacherMainInfo> searchTeacherbyKey(@Param("key") String key, @Param("start") int start, @Param("size") int size);

	@Select("select count(user_id) from t_teacher where "
			+ "teacher_name LIKE CONCAT('%', #{key}, '%') or teacher_title LIKE CONCAT('%', #{key}, '%') or "
			+ "teacher_post LIKE CONCAT('%', #{key}, '%') or teacher_hometown LIKE CONCAT('%', #{key}, '%') or "
			+ "teacher_major1 LIKE CONCAT('%', #{key}, '%') or teacher_major2 LIKE CONCAT('%', #{key}, '%') or "
			+ "teacher_workschool LIKE CONCAT('%', #{key}, '%') or teacher_sex LIKE CONCAT('%', #{key}, '%') ")
	int countTeacherbyKey(String key);
	
	@Select("select user_id from t_teacher where "+
			"teacher_name LIKE CONCAT('%', #{key}, '%') or teacher_title LIKE CONCAT('%', #{key}, '%') or " + 
			"teacher_post LIKE CONCAT('%', #{key}, '%') or teacher_hometown LIKE CONCAT('%', #{key}, '%') or " + 
			"teacher_major1 LIKE CONCAT('%', #{key}, '%') or teacher_major2 LIKE CONCAT('%', #{key}, '%') or " + 
			"teacher_workschool LIKE CONCAT('%', #{key}, '%') or teacher_sex LIKE CONCAT('%', #{key}, '%')")
	List<Integer> searchTeacherIdbyKey(String key);
	
	@Select("<script>" +
			"select user_id from t_teacher " +
			"<where>" +
			"user_id in " +
			"<foreach collection='user_ids' item='user_id' index='index' open='(' separator=',' close=')'>" +
			"#{user_id}" +
			"</foreach>" +
			" and (" +
			"teacher_name LIKE CONCAT('%', #{key}, '%') or teacher_title LIKE CONCAT('%', #{key}, '%') or " + 
			"teacher_post LIKE CONCAT('%', #{key}, '%') or teacher_hometown LIKE CONCAT('%', #{key}, '%') or " + 
			"teacher_major1 LIKE CONCAT('%', #{key}, '%') or teacher_major2 LIKE CONCAT('%', #{key}, '%') or " + 
			"teacher_workschool LIKE CONCAT('%', #{key}, '%') or teacher_sex LIKE CONCAT('%', #{key}, '%'))" +
			"</where>" +
			"</script>")
	List<Integer> searchTeacherIdbyKeyId(@Param("key") String key, @Param("user_ids") List<Integer> user_id);
	
	@Select("<script>"
			+ "select user_id, teacher_name, teacher_hometown, teacher_sex, teacher_workschool, teacher_major1, teacher_major2, "
			+ "teacher_title, teacher_post, teacher_teach_state from t_teacher where user_id in "
			+ "<foreach collection='arg0' item='user_id' index='index' open='(' separator=',' close=')'>"
			+ "#{user_id}"
			+ "</foreach>"
			+ "limit #{arg1}, #{arg2}"
			+ "</script>")
	@Results({
		@Result(id=true, property="userInfo", column="user_id", javaType=UserInfo.class, 
				one=@One(select="getUserInfobyId", fetchType=FetchType.EAGER))
	})
	List<TeacherMainInfo> searchTeacherbyId(List<Integer> user_id, int start, int size);
	
}
