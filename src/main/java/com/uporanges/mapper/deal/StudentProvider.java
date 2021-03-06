package com.uporanges.mapper.deal;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.StudentSendResume;
import com.uporanges.entity.User;
import com.uporanges.evo.TStudentResume;
import com.uporanges.evo.TStudentSendResume;
import com.uporanges.evo.TTeacherVerifyStudent;

public class StudentProvider {

	public String addStudent(final Student student) {
		return new SQL() {
			{
				INSERT_INTO("t_student");
				VALUES("user_id", "#{user.user_id}");
				VALUES("stu_email", "#{stu_email}");
				VALUES("stu_createdtime", "#{stu_createdtime, jdbcType=TIMESTAMP}");
				VALUES("stu_realname", "#{stu_realname}");
				VALUES("stu_status", "#{stu_status}");
				if(student.getStu_qq()!=null)
					VALUES("stu_qq", "#{stu_qq}");
				VALUES("stu_school", "#{stu_school}");
				VALUES("stu_major", "#{stu_major}");
				VALUES("stu_graduationtime", "#{stu_graduationtime, jdbcType=DATE}");
				VALUES("stu_sex", "#{stu_sex}");
				VALUES("stu_age", "#{stu_age}");
				VALUES("stu_address", "#{stu_address}");
				VALUES("is_mobile_check", "#{is_mobile_check}");
				if(student.getStu_target_job()!=null)
					VALUES("stu_target_job", "#{stu_target_job}");
				VALUES("last_login_time", "#{last_login_time, jdbcType=TIMESTAMP}");
			}
		}.toString();
	}
	public String addUser(User user) {
		return new SQL() {
			{
				INSERT_INTO("t_user");
				VALUES("user_name", "#{user_name}");
				VALUES("user_password", "#{user_password}");
				VALUES("user_phone", "#{user_phone}");
				VALUES("role_id", "#{role_id}");
			}
		}.toString();
	}
	public String alterStudent(final Student student) {
		return new SQL() {
			{
				UPDATE("t_student");
				if(student.getStu_email()!=null)
					SET("stu_email = #{stu_email}");
				if(student.getStu_realname()!=null)
					SET("stu_realname = #{stu_realname}");
				if(student.getStu_qq()!=null)
					SET("stu_qq = #{stu_qq}");
				if(student.getStu_school()!=null)
					SET("stu_school", "#{stu_school}");
				if(student.getStu_major()!=null)
					SET("stu_major = #{stu_major}");
				if(student.getStu_graduationtime()!=null)
					SET("stu_graduationtime = #{stu_graduationtime, jdbcType=DATE}");
				if(student.getStu_sex()!=3)
					SET("stu_sex = #{stu_sex}");
				if(student.getStu_age()!=0)
					SET("stu_age = #{stu_age}");
				if(student.getStu_address()!=null)
					SET("stu_address = #{stu_address}");
				if(student.getStu_target_job()!=null)
					SET("stu_target_job = #{stu_target_job}");
				WHERE("user_id = #{user.user_id}");
			}
		}.toString();
	}
	public String addResume(final StudentResume sr, String resumePic, String resumeDocument) {
		return new SQL() {
			{
				INSERT_INTO("t_student_resume");
				VALUES("user_id", "#{arg0.student.user.user_id}");
				VALUES("resume_name", "#{arg0.resume_name}");
				VALUES("resume_pic", "#{arg1}");
				VALUES("resume_sex", "#{arg0.resume_sex}");
				VALUES("resume_birthday", "#{arg0.resume_birthday, jdbcType=DATE}");
				VALUES("resume_country", "#{arg0.resume_country}");
				VALUES("resume_address", "#{arg0.resume_address}");
				VALUES("resume_phone1", "#{arg0.resume_phone1}");
				if(sr.getResume_phone2()!=null)
					VALUES("resume_phone2", "#{arg0.resume_phone2}");
				VALUES("resume_school", "#{arg0.resume_school}");
				VALUES("resume_graduationtime", "#{arg0.resume_graduationtime, jdbcType=DATE}");
				VALUES("education_id1", "#{arg0.education_id1.code_id}");
				if(sr.getCertificate_id1().getCode_id()!=0)
					VALUES("certificate_id1", "#{arg0.certificate_id1.code_id}");
				if(sr.getCertificate_id2().getCode_id()!=0)
					VALUES("certificate_id2", "#{arg0.certificate_id2.code_id}");
				if(sr.getCertificate_id3().getCode_id()!=0)
					VALUES("certificate_id3", "#{arg0.certificate_id3.code_id}");
				VALUES("resume_major1", "#{arg0.resume_major1.code_id}");
				if(sr.getResume_major2().getCode_id()!=0)
					VALUES("resume_major2", "#{arg0.resume_major2.code_id}");
				if(sr.getResume_honor()!=null)
					VALUES("resume_honor", "#{arg0.resume_honor}");
				if(sr.getResume_project_experience()!=null)
					VALUES("resume_project_experience", "#{arg0.resume_project_experience}");
				if(sr.getResume_internship_experience()!=null)
					VALUES("resume_internship_experience", "#{arg0.resume_internship_experience}");
				if(sr.getResume_school_experience()!=null)
					VALUES("resume_school_experience", "#{arg0.resume_school_experience}");
				if(sr.getResume_works()!=null)
					VALUES("resume_works", "#{arg0.resume_works}");
				if(sr.getResume_hobby()!=null)
					VALUES("resume_hobby", "#{arg0.resume_hobby}");
				if(sr.getResume_evaluate()!=null)
					VALUES("resume_evaluate", "#{arg0.resume_evaluate}");
				VALUES("resume_document", "#{arg2}");
				VALUES("resume_creattime", "#{arg0.resume_creattime, jdbcType=TIMESTAMP}");
			}
		}.toString();
	}
	public String alterResume(final TStudentResume tsr, final String resumePic, final String resumeDocument) {
		return new SQL() {
			{
				UPDATE("t_student_resume");
				if(tsr.getResume_name()!=null)
					SET("resume_name = #{param1.resume_name}");
				if(resumePic!="")
					SET("resume_pic = #{param2}");
				if(tsr.getResume_sex()!=null)
					SET("resume_sex = #{param1.resume_sex}");
				if(tsr.getResume_birthday()!=null)
					SET("resume_birthday = #{param1.resume_birthday, jdbcType=DATE}");
				if(tsr.getResume_country()!=null)
					SET("resume_country = #{param1.resume_country}");
				if(tsr.getResume_address()!=null)
					SET("resume_address = #{param1.resume_address}");
				if(tsr.getResume_phone1()!=null)
					SET("resume_phone1 = #{param1.resume_phone1}");
				if(tsr.getResume_phone2()!=null)
					SET("resume_phone2 = #{param1.resume_phone2}");
				if(tsr.getResume_school()!=null)
					SET("resume_school = #{param1.resume_school}");
				if(tsr.getResume_graduationtime()!=null)
					SET("resume_graduationtime = #{param1.resume_graduationtime, jdbcType=DATE}");
				if(tsr.getEducation_id1()!=0)
					SET("education_id1 = #{param1.education_id1}");
				if(tsr.getCertificate_id1()!=0)
					SET("certificate_id1 = #{param1.certificate_id1}");
				if(tsr.getCertificate_id2()!=0)
					SET("certificate_id2 = #{param1.certificate_id2}");
				if(tsr.getCertificate_id3()!=0)
					SET("certificate_id3 = #{param1.certificate_id3}");
				if(tsr.getResume_major1()!=0)
					SET("resume_major1 = #{param1.resume_major1}");
				if(tsr.getResume_major2()!=0)
					SET("resume_major2 = #{param1.resume_major2}");
				if(tsr.getResume_honor()!=null)
					SET("resume_honor = #{param1.resume_honor}");
				if(tsr.getResume_project_experience()!=null)
					SET("resume_project_experience = #{param1.resume_project_experience}");
				if(tsr.getResume_internship_experience()!=null)
					SET("resume_internship_experience = #{param1.resume_internship_experience}");
				if(tsr.getResume_school_experience()!=null)
					SET("resume_school_experience = #{param1.resume_school_experience}");
				if(tsr.getResume_works()!=null)
					SET("resume_works = #{param1.resume_works}");
				if(tsr.getResume_hobby()!=null)
					SET("resume_hobby = #{param1.resume_hobby}");
				if(tsr.getResume_evaluate()!=null)
					SET("resume_evaluate = #{param1.resume_evaluate}");
				if(resumeDocument!="")
					SET("resume_document = #{param3}");
				WHERE("resume_id=#{param1.resume_id} and user_id=#{param1.user_id}");
			}
		}.toString();
	}
	public String sendResume(final TStudentSendResume tssr) {
		return new SQL() {
			{
				INSERT_INTO("t_student_send_resume");
				VALUES("user_id", "#{user_id}");
				VALUES("resume_id", "#{resume_id}");
				VALUES("company_id", "#{company_id}");
				VALUES("expect_job_id1", "#{expect_job_id1}");
				if(tssr.getExpect_job_id2()!=0)
					VALUES("expect_job_id2", "#{expect_job_id2}");
				VALUES("resume_expect_workplace1", "#{resume_expect_workplace1}");
				if(tssr.getResume_expect_workplace2()!=null)
					VALUES("resume_expect_workplace2", "#{resume_expect_workplace2}");
				if(tssr.getResume_expect_salary()!=null)
					VALUES("resume_expect_salary", "#{resume_expect_salary}");
				if(tssr.getResume_to_work_time()!=null)
					VALUES("resume_to_work_time", "#{resume_to_work_time, jdbcType=DATE}");
				VALUES("delivar_state", "#{delivar_state}");
				VALUES("deliver_time", "#{deliver_time, jdbcType=TIMESTAMP}");
			}	
		}.toString();
	}
	public String toTeacher(final TTeacherVerifyStudent ttvs) {
		return new SQL() {
			{
				INSERT_INTO("t_teacher_verify_student");
				VALUES("student_id", "#{student_id}");
				VALUES("teacher_id", "#{teacher_id}");
				VALUES("join_state", "#{join_state}");
				VALUES("join_time", "#{join_time, jdbcType=TIMESTAMP}");
				if(ttvs.getStudent_message()!=null)
					VALUES("student_message", "#{student_message}");
			}
		}.toString();
	}
	public String getCompanyMainInfobyId(final List<Integer> companyId, int start, int size) {
		String sql = new SQL() {
			{
				StringBuilder sb = new StringBuilder();
				int i = 0;
				for(; i<companyId.size()-1; i++)
					sb.append(companyId.get(i)+",");
				sb.append(companyId.get(i));
				sb.append(")");
				SELECT("user_id, company_realname, company_trade, company_nature, company_address, company_logo_pic, company_brief");
				FROM("t_company");
				WHERE("user_id in ("+sb.toString());
			}
		}.toString();
		//此处参数不可以用$
		sql += " limit #{arg1}, #{arg2}";
		return sql;
	}
	public String searchJobbyId(List<Integer> job_ids, int start, int size) {
		StringBuilder sb = new StringBuilder();
		int idSize = job_ids.size();
		sb.append("select * from t_job where job_id in (");
		for(int i=0; i<idSize-1; i++)
			sb.append(job_ids.get(i)+",");
		sb.append(job_ids.get(idSize-1)+") limit "+start+","+size);
		return sb.toString();
	}
	public String searchCompanybySelect(int job_id, int start, int size) {
		String sql = new SQL() {
			{
				SELECT("j.job_id, j.job_name, j.job_type, cj.job_describe, cj.job_salary, "
						+ "c.company_realname, c.company_address, u.user_id, u.user_name");
				FROM("t_job as j, t_company_job as cj, t_company as c, t_user as u");
				WHERE("j.job_id = #{param1}");
				AND();
				WHERE("cj.job_id = j.job_id");
				AND();
				WHERE("c.user_id = cj.company_id");
				AND();
				WHERE("u.user_id = c.user_id");
			}
		}.toString();
		sql += "limit #{param2}, #{param3}";
		return sql;
	}
	public String alterSendResume(final StudentSendResume ssr) {
		return new SQL() {
			{
				UPDATE("t_student_send_resume");
				if(ssr.getJob1()!=null)
					SET("expect_job_id1 = #{job1.job_id}");
				if(ssr.getJob2()!=null)
					SET("expect_job_id2 = #{job2.job_id}");
				if(ssr.getResume_expect_workplace1()!=null)
					SET("resume_expect_workplace1 = #{resume_expect_workplace1}");
				if(ssr.getResume_expect_workplace2()!=null)
					SET("resume_expect_workplace2 = #{resume_expect_workplace2}");
				if(ssr.getResume_expect_salary()!=null)
					SET("resume_expect_salary = #{resume_expect_salary}");
				if(ssr.getResume_to_work_time()!=null)
					SET("resume_to_work_time = #{resume_to_work_time}");
				SET("deliver_time = #{deliver_time}");
				WHERE("send_resume_id = #{send_resume_id}");
			}
		}.toString();
	}
	
}
