package com.uporanges.controller.deal;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.StudentResumePicDoc;
import com.uporanges.evo.TStudentResume;
import com.uporanges.evo.TStudentSendResume;
import com.uporanges.evo.TTeacherVerifyStudent;
import com.uporanges.service.deal.StudentService;
import com.uporanges.util.Util;


/**
 * 学生相关方法
 * @author bc
 * @date 2018年10月15日
 */
@Controller
@RequestMapping("/student/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/*
	 * bc 10.16
	 * 注册时判断手机号或邮箱是否注册过
	 */
	@GetMapping("ifPhoneIn")
	public void ifPhoneIn(String phone, HttpServletResponse response) {
		String data = "{\"code\":0}";
		if(studentService.ifPhoneIn(phone))
			data = "{\"code\":1}";
		Util.writeJson(response, data);
	}
	@GetMapping("ifeMailIn")
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
	@PostMapping("addStudent")
	public void addStudent(@RequestBody Student student, HttpServletResponse response){
//	public void addStudent(@ModelAttribute Student student, HttpServletResponse response){
		String data = "{\"code\":200}";
		if(studentService.addStudent(student)!=1)
			data = "{\"code\":400}";
		Util.writeJson(response, data);
	}
	@PostMapping("addUserStudent")
	@ResponseBody
	public Map<String, Object> addUserStudent(@RequestBody User user, @RequestBody Student student) {
		return studentService.addUserStudent(user, student);
	}
	/*
	 * bc 2018.10.15
	 * 学生修改个人信息
	 */
	@PostMapping("alterStudent")
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
	@GetMapping("getStudentInfo")
	@ResponseBody
	public BackJSON getStudentInfo(String user_id) {
		return studentService.getStudentInfo(user_id);
	}
	/*
	 * bc 10.17
	 * 学生添加基础简历
	 */
	@PostMapping("addResume")
	public void addResume(@RequestBody StudentResume studentResume, HttpServletResponse response) {
		Util.writeJson(response, studentService.addResume(studentResume));
	}
	//提供选择的学历or荣誉证书or专业
	@GetMapping(value="selectCode")
	public void selectCode(@RequestParam("code_name")String codeName, HttpServletResponse response) {
		Util.writeJson(response, studentService.selectCode(codeName));
	}
	//学生修改基础简历
	@PostMapping("alterResume")
	public void alterResume(@RequestBody TStudentResume tStudentResume, HttpServletResponse response) {
		Util.writeJson(response, studentService.alterResume(tStudentResume));
	}
	//学生直接添加简历新头像，覆盖原来的头像
	@PostMapping("updateResumePic")
	public void updateResumePic(@RequestBody StudentResumePicDoc srpd, HttpServletResponse response) {
		Util.writeJson(response, studentService.updateResumePic(srpd));
	}
	//学生删除简历头像或附件
	@RequestMapping("deleteResumePicDoc")
	public void deleteResumePicDoc(int resume_id, int user_id, int id, HttpServletResponse response) {
		Util.writeJson(response, studentService.deleteResumePicDoc(resume_id, user_id, id));
	}
	//学生简历附件,在删除完的基础上
	@PostMapping("updateResumeDoc")
	public void updateResumeDoc(@RequestBody StudentResumePicDoc srpd, HttpServletResponse response) {
		Util.writeJson(response, studentService.updateResumeDoc(srpd));
	}
	//学生删除基础简历
	@DeleteMapping("deleteResume")
	public void deleteResume(int user_id, int resume_id, HttpServletResponse response) {
		Util.writeJson(response, studentService.deleteResume(user_id, resume_id));
	}
	//学生查看自己简历
	@GetMapping("seeResume")
	@ResponseBody
	public BackJSON getStudentResume(int user_id) {
		return studentService.getStudentResume(user_id);
	}
	//下载简历附件
	@GetMapping("downDocument")
	public ResponseEntity<byte[]> downDocument(String documentPath) throws IOException {
		File file = new File(documentPath);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		header.setContentDispositionFormData("attachment", documentPath);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), header, HttpStatus.CREATED);
	}
	//学生向公司发送简历
	@RequestMapping("sendResume")
	public void sendResume(@RequestBody TStudentSendResume tStudentSendResume, HttpServletResponse response) {
		Util.writeJson(response, studentService.sendResume(tStudentSendResume));
	}
	//学生查询公司提供岗位
	@GetMapping("companyJob")
	@ResponseBody
	public BackJSON getCompanyJob(int company_id) {
		return studentService.getCompanyJob(company_id);
	}
	//学生向老师提交申请
	@RequestMapping("toTeacher")
	public void toTeacher(@RequestBody TTeacherVerifyStudent ttvs, HttpServletResponse response) {
		Util.writeJson(response, studentService.toTeacher(ttvs));
	}

	
}
