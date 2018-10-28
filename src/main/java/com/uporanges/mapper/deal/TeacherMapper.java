package com.uporanges.mapper.deal;



import java.util.List;
import java.util.Map;

import com.uporanges.entity.Teacher;

import com.uporanges.evo.data_teacher;

public interface TeacherMapper {

	int checkrole(int user_id);
	
	Teacher getTeacherInfo(int user_id);
	
	int addteacherself(Teacher teacher);
	
	int updateByPrimaryKeySelective(Teacher teacher);
	
	List<Map<String, Object>> getTS_verify(int teacher_id);
	
	int TeacherVerifyStudent(int teacher_id,int student_id);
	
	int TeacherRecommendStu(data_teacher data);
	
	String getuserbyid(Long long1);
	
}
