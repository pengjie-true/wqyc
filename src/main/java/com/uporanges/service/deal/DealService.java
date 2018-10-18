package com.uporanges.service.deal;

import java.util.List;
import java.util.Map;

import com.uporanges.entity.Code;
import com.uporanges.evo.BackJSON;

public interface DealService {

	List<Code> testGetAllCode();
	BackJSON getTeacherInfo(int user_id);
	Map<String, Object> getTeacherInfoD(int user_id);
	
}
