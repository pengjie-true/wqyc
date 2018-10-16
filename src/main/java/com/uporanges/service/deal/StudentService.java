package com.uporanges.service.deal;

import java.util.Map;

import com.uporanges.entity.Student;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;

public interface StudentService {

	//增加学生，添加学生信息
	public int addStudent(Student student);
	//增加学生，新用户信息与学生信息同时添加
	public Map<String, Object> addUserStudent(User user, Student student);
	//修改学生信息
	public int alterStudent(Student student);
	//查询学生个人信息
	public BackJSON getStudentInfo(String user_id);
	//根据phone判断是否已经注册
	public boolean ifPhoneIn(String phone);
	//根据email判断是否已经注册
	public boolean ifeMailIn(String email);
	
}
