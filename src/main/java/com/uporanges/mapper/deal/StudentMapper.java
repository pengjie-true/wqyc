package com.uporanges.mapper.deal;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.uporanges.entity.Student;
import com.uporanges.entity.User;
import com.uporanges.evo.StudentInfo;

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
	
	@Update("update t_user set user_pic=#{1} where user_id=#{0}")
	void addUserPicture(int user_id, String user_pic);
	
	@UpdateProvider(type=StudentProvider.class, method="alterStudent")
	int alterStudent(Student student);
	
	@Select("select * from t_student where user_id = #{user_id}")
	StudentInfo getStudentInfo(String user_id);
	
}
