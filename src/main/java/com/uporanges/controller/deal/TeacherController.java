package com.uporanges.controller.deal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uporanges.entity.Teacher;
import com.uporanges.entity.TeacherRecommend;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.data_teacher;
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
	public BackJSON getteacherself(int user_id) {
		return teacherservice.getteacherself(user_id);
	}

	/**
	 * //老师增加信息
	 * 
	 * @param teacher
	 * @param user_id
	 * @return
	 */

	@PostMapping("addteacherself")
	public BackJSON addteacherself(Teacher teacher, int user_id) {
		User user = new User();
		user.setUser_id(user_id);
		teacher.setUser(user);
		return teacherservice.addteacherself(teacher);

	}

	/**
	 * 老师修个人信息
	 * 
	 * @param teacher
	 * @param user_id
	 * @return
	 */

	@PostMapping("updateteacherself")
	public BackJSON updateteacherself(Teacher teacher, int user_id) {
		User user = new User();
		user.setUser_id(user_id);
		teacher.setUser(user);
		teacher.setTeacher_name("教授易小星");
		return teacherservice.updateByPrimaryKeySelective(teacher);
	}

	/**
	 * 教师查看加入学生接口
	 * 
	 * @param teacher_id
	 * @param student_id
	 * @return
	 */
	@GetMapping("checkstudentjoin")
	public BackJSON checkstudentjoin(int teacher_id) {
		return teacherservice.getTS_verify(teacher_id);

	}

	/**
	 * 教师审核学生加入接口
	 * 
	 * @return
	 */
	@GetMapping("verifystujoin")
	public BackJSON verifystujoin(int teacher_id, int student_id) {
		return teacherservice.TeacherVerifyStudent(teacher_id, student_id);
	}

	/**
	 * 老师推荐学生接口
	 * http://localhost:8080/qwyc1-0/teacher/teacherecommendstu.shtml?teacher_id=2&student_id=4&company_id=3&recommend_describe=111
	 */
	@GetMapping("teacherecommendstu")
	public BackJSON teacherecommendstu(data_teacher data) {
		data.setRecommend_time(new Date());
		return teacherservice.TeacherRecommendStu(data);
	}

}
