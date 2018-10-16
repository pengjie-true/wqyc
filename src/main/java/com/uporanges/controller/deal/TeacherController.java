package com.uporanges.controller.deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uporanges.evo.BackJSON;
import com.uporanges.service.deal.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherservice;

	// 第一个测试教师接口
	@GetMapping("/test")
	public int test() {
		return 11111;
	}

	/**
	 * /教师查看自己信息接口
	 * 
	 * @param user_id
	 * @return
	 */
	@GetMapping("getteacherself")
	public BackJSON getteacherself (String user_id) {
	   return  teacherservice.getteacherself(user_id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
