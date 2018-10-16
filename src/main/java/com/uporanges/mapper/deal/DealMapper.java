package com.uporanges.mapper.deal;

import java.util.List;

import com.uporanges.entity.Code;
import com.uporanges.entity.Teacher;

public interface DealMapper {

	List<Code> testGetAllCode();
	Teacher getTeacherInfo(int user_id);
	
}
