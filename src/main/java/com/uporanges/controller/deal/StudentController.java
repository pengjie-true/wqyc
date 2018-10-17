package com.uporanges.controller.deal;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uporanges.entity.Student;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.service.deal.StudentService;
import com.uporanges.util.Util;


/**
 * 学生相关方法
 * @author bc
 * @date 2018年10月15日
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/*
	 * bc 10.16
	 * 注册时判断手机号或邮箱是否注册过
	 */
	@GetMapping("/ifPhoneIn")
	public void ifPhoneIn(String phone, HttpServletResponse response) {
		String data = "{\"code\":0}";
		if(studentService.ifPhoneIn(phone))
			data = "{\"code\":1}";
		Util.writeJson(response, data);
	}
	@GetMapping("/ifeMailIn")
	public void ifeMainlIn(String email, HttpServletResponse response) {
		String data = "{\"code\":0}";
		if(studentService.ifeMailIn(email))
			data = "{\"code\":1}";
		Util.writeJson(response, data);
	}
	/*
	 * bc 10.16
	 * 增加学生信息,已经是用户
	 * 增加学生，新用户需要注册新用户
	 * 这两个方法目前采用requestBody注解，暂时测试不了，如果后期测试不可以的话，用modelAttribute注解是可以的，打开下面的注释。
	 */
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student, HttpServletResponse response){
//	public void addStudent(@ModelAttribute Student student, HttpServletResponse response){
		String data = "{\"code\":200}";
		if(studentService.addStudent(student)!=1)
			data = "{\"code\":400}";
		Util.writeJson(response, data);
	}
	@PostMapping("/addUserStudent")
	@ResponseBody
	public Map<String, Object> addUserStudent(@RequestBody User user, @RequestBody Student student) {
		return studentService.addUserStudent(user, student);
	}
	/*
	 * bc 2018.10.15
	 * 学生修改个人信息
	 */
	@PostMapping("/alterStudent")
	public void alterStudent(@RequestBody Student student, HttpServletResponse response){
		String data = "{\"code\":200}";
		if(studentService.alterStudent(student)!=1)
			data = "{\"code\":400}";
		Util.writeJson(response, data);
	}
	/*
	 * bc 10.16
	 * 查看学生信息
	 */
	@GetMapping("/getStudentInfo")
	@ResponseBody
	public BackJSON getStudentInfo(String user_id) {
		return studentService.getStudentInfo(user_id);
	}
	
}
