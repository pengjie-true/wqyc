package com.uporanges.mapper.deal;

import org.apache.ibatis.jdbc.SQL;

import com.uporanges.entity.Student;
import com.uporanges.entity.User;

public class StudentProvider {

	public String addStudent(final Student student) {
		return new SQL() {
			{
				INSERT_INTO("t_student");
				VALUES("user_id", "#{user.user_id}");
				VALUES("stu_email", "#{stu_email}");
				VALUES("stu_createdtime", "#{stu_createdtime}");
				VALUES("stu_realname", "#{stu_realname}");
				VALUES("stu_status", "#{stu_status}");
				if(student.getStu_qq()!=null)
					VALUES("stu_qq", "#{stu_qq}");
				VALUES("stu_school", "#{stu_school}");
				VALUES("stu_major", "#{stu_major}");
				VALUES("stu_graduationtime", "#{stu_graduationtime}");
				VALUES("stu_sex", "#{stu_sex}");
				VALUES("stu_age", "#{stu_age}");
				VALUES("stu_address", "#{stu_address}");
				VALUES("is_mobile_check", "#{is_mobile_check}");
				if(student.getStu_target_job()!=null)
					VALUES("stu_target_job", "#{stu_target_job}");
				VALUES("last_login_time", "#{last_login_time}");
			}
		}.toString();
	}
	public String addUser(User user, final String picPath) {
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
					SET("stu_email", "#{stu_email}");
				if(student.getStu_realname()!=null)
					SET("stu_realname", "#{stu_realname}");
				if(student.getStu_qq()!=null)
					SET("stu_qq", "#{stu_qq}");
				if(student.getStu_school()!=null)
					SET("stu_school", "#{stu_school}");
				if(student.getStu_major()!=null)
					SET("stu_major", "#{stu_major}");
				if(student.getStu_graduationtime()!=null)
					SET("stu_graduationtime", "#{stu_graduationtime}");
				if(student.getStu_sex()!=3)
					SET("stu_sex", "#{stu_sex}");
				if(student.getStu_age()!=0)
					SET("stu_age", "#{stu_age}");
				if(student.getStu_address()!=null)
					SET("stu_address", "#{stu_address}");
				if(student.getStu_target_job()!=null)
					SET("stu_target_job", "#{stu_target_job}");
				WHERE("user_id = #{user.user_id}");
			}
		}.toString();
	}
	
}
