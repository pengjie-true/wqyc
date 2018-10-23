package com.uporanges.mapper.deal;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.uporanges.entity.Code;
import com.uporanges.entity.CompanyJob;
import com.uporanges.entity.Job;
import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.StudentSendResume;
import com.uporanges.entity.User;
import com.uporanges.evo.StuApplyTeacher;
import com.uporanges.evo.StuCollectJob;
import com.uporanges.evo.StuCollectJobT;
import com.uporanges.evo.StuResumeCheck;
import com.uporanges.evo.StuResumeCompany;
import com.uporanges.evo.StuSendResume;
import com.uporanges.evo.StudentInfo;
import com.uporanges.evo.TStudentResume;
import com.uporanges.evo.TStudentSendResume;
import com.uporanges.evo.TTeacherVerifyStudent;
import com.uporanges.evo.TeacherCompany;

public interface StudentMapper {

	@Select("select user_id, user_name from t_user where user_phone=#{phone}")
	User getUseridName(String phone);
	
	@Select("select user_id, stu_realname from t_student where stu_email=#{email} and stu_status=1")
	User getStudentIdName(String email);
	
	@InsertProvider(type=StudentProvider.class, method="addStudent")
	int addStudent(Student student);
	
	@InsertProvider(type=StudentProvider.class, method="addUser")
	@Options(useGeneratedKeys=true, keyProperty="user_id")
	int addUser(User user);
	
	@Update("update t_user set user_pic=#{arg1} where user_id=#{arg0}")
	void addUserPicture(int user_id, String user_pic);
	
	@UpdateProvider(type=StudentProvider.class, method="alterStudent")
	int alterStudent(Student student);
	
	@Select("select * from t_student where user_id = #{user_id}")
	StudentInfo getStudentInfo(String user_id);
	
	@InsertProvider(type=StudentProvider.class, method="addResume")
	@Options(useGeneratedKeys=true, keyProperty="arg0.resume_id")
//	@SelectKey(before=false, keyProperty="arg0.resume_id", resultType=Integer.class, statement={"SELECT LAST_INSERT_ID()"})
	int addResume(StudentResume studentResume, String resume_pic, String resumeDocument);
	
	@Select("select * from t_code where code_name=#{codeName}")
	List<Code> getCodebyName(String codeName);
	
	@UpdateProvider(type=StudentProvider.class, method="alterResume")
	int alterResume(TStudentResume tStudentResume, String resume_pic, String resumeDocument);
	
	@Select("select resume_pic, resume_document from t_student_resume where resume_id=#{arg0} and user_id=#{arg1}")
	Map<String, Object> getFilePathbyId(int resume_id, int user_id);
	
	@Update("update t_student_resume set resume_pic=#{resume_pic} where resume_id=#{resume_id} and user_id=#{user_id}")
	int updateResumePic(@Param("resume_id")int resume_id, @Param("user_id")int user_id, @Param("resume_pic")String resume_pic);
	
	@Update("update t_student_resume set resume_document=#{arg2} where resume_id=#{arg0} and user_id=#{arg1}")
	int updateResumeDoc(int resume_id, int user_id, String resume_document);
	
	@Delete("delete from t_student_resume where resume_id=#{param2} and user_id=#{param1}")
	int deleteResume(int user_id, int resume_id);

	@Select("select * from t_student_resume where user_id=#{user_id}")
	@Results({
		@Result(id=true, property="resume_id", column="resume_id"),
		@Result(property="resume_pic_path", column="resume_pic"),
		@Result(property="education_id1", column="education_id1", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="certificate_id1", column="certificate_id1", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="certificate_id2", column="certificate_id2", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="certificate_id3", column="certificate_id3", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="resume_major1", column="resume_major1", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="resume_major2", column="resume_major2", javaType=Code.class,
		one=@One(select="getCodebyId", fetchType=FetchType.EAGER)),
		@Result(property="resume_document_path", column="resume_document")
	})
	StudentResume getStudentResume(int user_id);
	
	@Select("select * from t_code where code_id=#{code_id}")
	Code getCodebyId(Integer code_id);
	
	@InsertProvider(type=StudentProvider.class, method="sendResume")
	@Options(useGeneratedKeys=true, keyProperty="send_resume_id")
	int sendResume(TStudentSendResume tStudentSendResume);
	
	@Select("select j.* from t_job j where j.job_id in (select cj.job_id from t_company_job cj where cj.company_id=${_parameter})")
	List<Job> getCompanyJobs(int company_id);
	
	@Select("select * from t_job where job_id=#{job_id}")
	Job getJobbyId(Integer job_id);
	
//	@Insert("insert into t_teacher_verify_student values(#{student_id}, #{teacher_id}, #{join_state}, #{join_time, jdbcType=TIMESTAMP})")
	@InsertProvider(type=StudentProvider.class, method="toTeacher")
	int toTeacher(TTeacherVerifyStudent ttvs);
	
	@Select("select send_resume_id, company_id, expect_job_id1, expect_job_id2, deliver_time from t_student_send_resume "
			+ "where user_id = ${_parameter} and delivar_state = 0")
	@Results({
		@Result(id=true, property="send_resume_id", column="send_resume_id"),
		@Result(property="deliver_time", column="deliver_time", javaType=Timestamp.class),
		@Result(property="stuResumeCompany", column="company_id", javaType=StuResumeCompany.class, 
				one=@One(select="getStuResumeCompanyNP", fetchType=FetchType.EAGER)),
		@Result(property="job1", column="expect_job_id1", javaType=Job.class, 
				one=@One(select="getJobbyId", fetchType=FetchType.EAGER)),
		@Result(property="job2", column="expect_job_id2", javaType=Job.class, 
				one=@One(select="getJobbyId", fetchType=FetchType.EAGER))
	})
	List<StuResumeCheck> checkSendResume(int user_id);
	
	@Select("select user_id, company_realname, company_logo_pic from t_company where user_id = ${_parameter}")
	@Results({
		@Result(id=true, property="company_id", column="user_id")
	})
	StuResumeCompany getStuResumeCompanyNP(int company_id);
	
	@Select("select send_resume_id, company_id, deliver_time from t_student_send_resume "
			+ "where user_id = ${_parameter} and delivar_state = 1")
	@Results({
		@Result(id=true, property="send_resume_id", column="send_resume_id"),
		@Result(property="deliver_time", column="deliver_time", javaType=Timestamp.class),
		@Result(property="stuResumeCompany", column="company_id", javaType=StuResumeCompany.class, 
				one=@One(select="getStuResumeCompany", fetchType=FetchType.EAGER))
	})
	List<StuResumeCheck> passedResume(int user_id);
	
	@Select("select user_id, company_realname, company_phone1, company_phone2, company_email, company_logo_pic "
			+ "from t_company where user_id = ${_parameter}")
	@Results({
		@Result(id=true, property="company_id", column="user_id")
	})
	StuResumeCompany getStuResumeCompany(int company_id);
	
	@Select("select send_resume_id, company_id, deliver_time from t_student_send_resume "
			+ "where user_id = ${_parameter} and delivar_state = 2")
	@Results({
		@Result(id=true, property="send_resume_id", column="send_resume_id"),
		@Result(property="deliver_time", column="deliver_time", javaType=Timestamp.class),
		@Result(property="stuResumeCompany", column="company_id", javaType=StuResumeCompany.class, 
				one=@One(select="getStuResumeCompanyNP", fetchType=FetchType.EAGER)),
	})
	List<StuResumeCheck> rejectResume(int user_id);
	
	@Select("select * from t_student_send_resume where send_resume_id = ${_parameter}")
	@Results({
		@Result(property="resume_to_work_time", column="resume_to_work_time", javaType=java.sql.Date.class),
		@Result(property="deliver_time", column="deliver_time", javaType=Timestamp.class),
		@Result(property="job1", column="expect_job_id1", javaType=Job.class, 
				one=@One(select="getJobbyId", fetchType=FetchType.EAGER)),
		@Result(property="job_salary1", column="{job_id=expect_job_id1, company_id=company_id}", javaType=String.class, 
				one=@One(select="getJobSalary", fetchType=FetchType.EAGER)),
		@Result(property="job2", column="expect_job_id2", javaType=Job.class, 
				one=@One(select="getJobbyId", fetchType=FetchType.EAGER)),
		@Result(property="job_salary2", column="{job_id=expect_job_id2, company_id=company_id}", javaType=String.class, 
		one=@One(select="getJobSalary", fetchType=FetchType.EAGER)),
	})
	StuSendResume sendResumeDetail(int send_resume_id);
 	
	@Select("select job_salary from t_company_job where job_id=#{job_id} and company_id=#{company_id}")
	String getJobSalary(@Param("job_id") int expect_job_id, @Param("company_id") int company_id);
	
	@UpdateProvider(type=StudentProvider.class, method="alterSendResume")
	int alterSendResume(StudentSendResume ssr);
	
	@Delete("delete from t_student_send_resume where send_resume_id=#{arg0} and user_id=#{arg1}")
	int deleteSendResume(int send_resume_id, int user_id);
	
	//以下 三个方法，考虑效率问题？
	@Select("select tvs.join_time, tvs.student_message, t.user_id as teacher_id, t.teacher_name, teacher_workschool, teacher_title, teacher_post "
			+ "from t_teacher_verify_student tvs left join t_teacher t on t.user_id=tvs.teacher_id "
			+ "where (tvs.student_id=#{user_id} and tvs.join_state=0)")
	List<StuApplyTeacher> checkApplyTeacher(int user_id);
	
	@Select("select tvs.join_time, t.user_id as teacher_id, t.teacher_name, t.teacher_email, t.teacher_WeChat from t_teacher_verify_student tvs "
			+ "left join t_teacher t on (tvs.student_id=#{user_id} and t.user_id=tvs.teacher_id) where tvs.join_state=1")
	List<Map<String, Object>> passedTeacher(int user_id);
	
	@Select("select tvs.join_time, t.user_id as teacher_id, t.teacher_name from t_teacher_verify_student tvs, t_teacher t "
			+ "where tvs.student_id=#{user_id} and tvs.join_state=2 and t.user_id=tvs.teacher_id")
	List<Map<String, Object>> rejectTeacher(int user_id);
	
	@Select("select student_message from t_teacher_verify_student where student_id=#{student_id} and teacher_id=#{teacher_id}")
	String checkApplyDetail(@Param("student_id") int student_id, @Param("teacher_id") int teacher_id);
	
	@Update("update t_teacher_verify_student set student_message=#{student_message}, join_time=#{join_time} "
			+ "where student_id=#{student_id} and teacher_id=#{teacher_id}")
	int alterApplyTeacher(Map<String, Object> map);
	
	@Delete("delete from t_teacher_verify_student where student_id=#{arg0} and teacher_id=#{arg1}")
	int deleteApplyTeacher(int student_id, int teacher_id);
	
	@Insert("insert into t_student_collect_job values(#{user_id}, #{job_id}, #{company_id}, #{collect_time, jdbcType=DATE})")
	int collectJob(StuCollectJobT scj);
	
	@Select("select job_id, company_id, collect_time from t_student_collect_job where user_id = #{user_id}")
	@Results({
		@Result(property="collect_time", column="collect_time", javaType=Timestamp.class),
		@Result(property="teacherCompany", column="company_id", javaType=TeacherCompany.class, 
				one=@One(select="getTeacherCompany", fetchType=FetchType.EAGER)),
		@Result(property="job", column="job_id", javaType=Job.class, 
				one=@One(select="getJobbyId", fetchType=FetchType.EAGER)),
		@Result(property="companyJob", column= "{job_id, company_id}", javaType=CompanyJob.class, 
				one=@One(select="getCompanyJob", fetchType=FetchType.EAGER))
	})
	List<StuCollectJob> seeCollectJob(int user_id);
	
	@Select("select user_id as company_id, company_realname, company_trade, company_address, company_logo_pic "
			+ "from t_company where user_id=#{_parameter}")
	TeacherCompany getTeacherCompany(int company_id);
	
	@Select("select * from t_company_job where job_id=#{job_id} and company_id=#{company_id}")
	@Results({
		@Result(property="job_describe", column="job_describe"),
		@Result(property="job_salary", column="job_salary")
	})
	CompanyJob getCompanyJob(@Param("job_id") int job_id, @Param("company_id") int company_id);
	
	@Delete("delete from t_student_collect_job where user_id=#{arg0} and job_id=#{arg1} and company_id=#{arg2}")
	int deleteCollectJob(int user_id, int job_id, int company_id);
	
}
