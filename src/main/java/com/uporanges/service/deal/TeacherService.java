package com.uporanges.service.deal;

import com.uporanges.entity.Teacher;
import com.uporanges.entity.TeacherVerifyStudent;
import com.uporanges.evo.BackJSON;

public interface TeacherService {

	int checkrole(int user_id);

	BackJSON getteacherself(int user_id);
	
	BackJSON addteacherself(Teacher teacher);
	
	BackJSON updateByPrimaryKeySelective(Teacher teacher);
	
	BackJSON getTS_verify(int teacher_id);
	
	BackJSON TeacherVerifyStudent(int teacher_id,int student_id);

}
