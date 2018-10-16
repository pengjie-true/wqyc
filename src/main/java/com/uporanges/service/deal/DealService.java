package com.uporanges.service.deal;

import java.util.List;

import com.uporanges.entity.Code;
import com.uporanges.evo.BackJSON;

public interface DealService {

	List<Code> testGetAllCode();
	BackJSON getTeacherInfo(int user_id);
	
}
