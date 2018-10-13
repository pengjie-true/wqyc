package com.uporanges.controller.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uporanges.entity.t_student;
import com.uporanges.service.student.userservice;

@Controller


public class test {
   
	
	@Autowired
	userservice us;
	
	@RequestMapping("sss.shtml")
	@ResponseBody
	public List<t_student> sss() {
		
		return us.selectall();
	}
	public void bcP() {
		
	}
}
