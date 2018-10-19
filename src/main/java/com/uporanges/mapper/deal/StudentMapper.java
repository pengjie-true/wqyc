package com.uporanges.mapper.deal;

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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.uporanges.entity.Code;
import com.uporanges.entity.CompanyJob;
import com.uporanges.entity.Job;
import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.User;
import com.uporanges.evo.CompanyMainInfo;
import com.uporanges.evo.StudentInfo;
import com.uporanges.evo.TStudentResume;
import com.uporanges.evo.TStudentSendResume;
import com.uporanges.evo.TTeacherVerifyStudent;
import com.uporanges.evo.UserInfo;

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
	
	@Select("select * from t_company_job where company_id=#{company_id}")
	@Results({
		@Result(property="job_describe", column="job_describe"),
		@Result(property="job_salary", column="job_salary"),
		@Result(property="job", column="job_id", javaType=Job.class, 
		one=@One(select="getJobbyId", fetchType=FetchType.EAGER))
	})
	List<CompanyJob> getCompanyJob(int company_id);
	
	@Select("select * from t_job where job_id=#{job_id}")
	Job getJobbyId(Integer job_id);
	
	@Insert("insert into t_teacher_verify_student values(#{student_id}, #{teacher_id}, #{join_state}, #{join_time, jdbcType=TIMESTAMP})")
	int toTeacher(TTeacherVerifyStudent ttvs);
	
	@Select("select user_id, company_realname, company_trade, company_nature, company_address, company_logo_pic, company_brief "
			+ "from t_company limit ${start}, ${size}")
	@Results({
		@Result(property="user", column="user_id", javaType=UserInfo.class,
		one=@One(select="getUserbyId", fetchType=FetchType.EAGER))
	})
	List<CompanyMainInfo> getCompanyInfo(@Param("start")int start, @Param("size")int size);
	
	@Select("select user_id from t_company where company_realname like \"%\"#{key}\"%\" or company_trade like \"%\"#{key}\"%\" "
			+ "or company_nature like \"%\"#{key}\"%\" or company_address like \"%\"#{key}\"%\" or company_legal_person like \"%\"#{key}\"%\"")
	List<Integer> getCompanyIdbyKey(String key);
	
	@Select("<script>"
			+ "select user_id from t_company where user_id in "
			+ "<foreach item='item' index='index' collection='companyId' open='(' separator=',' close=')'>"
			+ "#{companyId}"
			+ "</foreach>"
			+ "and (company_realname like \"%\"#{key}\"%\" or company_trade like \"%\"#{key}\"%\" or "
			+ "company_nature like \"%\"#{key}\"%\" or company_address like \"%\"#{key}\"%\" or company_legal_person like \"%\"#{key}\"%\") "
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
	
	@Select("select user_id, user_name from t_user where user_id = ${_parameter}")
	UserInfo getUserbyId(Integer user_id);
	
}
