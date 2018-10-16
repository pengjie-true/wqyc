package com.uporanges.service.deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uporanges.evo.BackJSON;
import com.uporanges.mapper.deal.TeacherMapper;


@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherMapper teachermapper;

	// 检查是否是老师
	public int checkrole(String user_id) {
		// TODO Auto-generated method stub
		return teachermapper.checkrole(user_id);
	}

	// 老师查看自己信息
	public BackJSON getteacherself(String user_id) {
		BackJSON back = new BackJSON();
		if(teachermapper.checkrole(user_id)==1) {
			back.setCode(200);
		   back.setData(teachermapper.getall(user_id));
			return back;
		}
		back.setCode(400);
		back.setData("操作失败");
		return back;
		
	}

}
