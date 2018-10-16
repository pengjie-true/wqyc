package com.uporanges.mapper.deal;



import com.uporanges.entity.Teacher;

public interface TeacherMapper {

	int checkrole(String user_id);
	
	Teacher getall(String user_id);
	
}
