package com.uporanges.service.deal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uporanges.entity.Code;
import com.uporanges.entity.Teacher;
import com.uporanges.evo.BackJSON;
import com.uporanges.mapper.deal.DealMapper;

@Service
public class DealServiceImpl implements DealService{

	@Autowired
	private DealMapper dealMapper;
	
	public List<Code> testGetAllCode() {
		return dealMapper.testGetAllCode();
	}
	public BackJSON getTeacherInfo(int user_id) {
		BackJSON json = new BackJSON();
		Teacher teacher = dealMapper.getTeacherInfo(user_id);
		json.setData(200);
		if(teacher==null)
			json.setData(400);
		json.setData(teacher);
		return json;
	}

}
