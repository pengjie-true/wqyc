package com.uporanges.mapper.deal;

import java.util.List;
import java.util.Map;

import com.uporanges.entity.Code;
import com.uporanges.entity.Teacher;

public interface DealMapper {

	List<Code> testGetAllCode();
	Teacher getTeacherInfo(int user_id);
	Map<String, Object> getTeacherInfoD(int user_id);
	
}
