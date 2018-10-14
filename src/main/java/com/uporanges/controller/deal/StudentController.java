package com.uporanges.controller.deal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uporanges.entity.Student;
import com.uporanges.service.deal.StudentService;
import com.uporanges.util.Util;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/*
	 * 用户增加信息
	 * 用户修改个人信息
	 * 这两个方法目前采用requestBody注解，暂时不能测试，如果后期测试不可以的话，用modelAttribute注解是可以的，打开下面的注解。
	 */
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student, HttpServletResponse response){
//	public void addStudent(@ModelAttribute Student student, HttpServletResponse response){
		String data = "{\"code\":200}";
		if(studentService.addStudent(student)!=1)
			data = "{\"code\":400}";
		Util.writeJson(response, data);
	}
	@PostMapping("/alterStudent")
	public void alterStudent(@RequestBody Student student, HttpServletResponse response){
		String data = "{\"code\":200}";
		if(studentService.alterStudent(student)!=1)
			data = "{\"code\":400}";
		Util.writeJson(response, data);
	}
	
}
