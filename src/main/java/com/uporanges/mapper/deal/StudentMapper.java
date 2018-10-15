package com.uporanges.mapper.deal;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.uporanges.entity.Student;
import com.uporanges.entity.User;
import com.uporanges.evo.StudentInfo;

public interface StudentMapper {

	@InsertProvider(type=StudentProvider.class, method="addStudent")
	int addStudent(Student student);
	@InsertProvider(type=StudentProvider.class, method="addUser")
	@Options(useGeneratedKeys=true, keyProperty="user_id")
	int addUser(User user, String picPath);
	@UpdateProvider(type=StudentProvider.class, method="alterStudent")
	int alterStudent(Student student);
	@Select("select * from t_student where user_id = #{user_id}")
	StudentInfo getStudentInfo(String user_id);
	
}
