package com.uporanges.service.deal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uporanges.entity.Teacher;
import com.uporanges.entity.TeacherRecommend;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.data_teacher;
import com.uporanges.mapper.deal.TeacherMapper;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherMapper teachermapper;

	// 检查是否是老师。
	public int checkrole(int user_id) {
		// TODO Auto-generated method stub
		return teachermapper.checkrole(user_id);
	}

	// 老师查看自己信息
	public BackJSON getteacherself(int user_id) {
		BackJSON back = new BackJSON();
		if (teachermapper.checkrole(user_id) == 1) {
			back.setCode(200);
			back.setData(teachermapper.getTeacherInfo(user_id));
			return back;
		}
		back.setCode(400);
		back.setData("操作失败");
		return back;

	}

	// 老师增加信息
	public BackJSON addteacherself(Teacher teacher) {
		BackJSON back = new BackJSON();
		// TODO Auto-generated method stub
		if (teachermapper.checkrole(teacher.getUser().getUser_id()) == 1) {
			if (teachermapper.addteacherself(teacher) > 0) {
				back.setCode(200);
				back.setData("添加成功");
				return back;
			} else {
				back.setCode(400);
				back.setData("添加失败");
				return back;
			}
		}

		back.setCode(400);
		back.setData("没有此用户");
		return back;
	}
	// 老师修改自己信息

	public BackJSON updateByPrimaryKeySelective(Teacher teacher) {
		// TODO Auto-generated method stub
		BackJSON back = new BackJSON();
		if (teachermapper.checkrole(teacher.getUser().getUser_id()) == 1) {
			if (teachermapper.updateByPrimaryKeySelective(teacher) > 0) {
				back.setCode(200);
				back.setData("修改成功");
				return back;
			} else {
				back.setCode(400);
				back.setData("添加失败");
				return back;
			}

		}
		back.setCode(400);
		back.setData("没有此用户");
		return back;
	}

	// 教师查看申请学生加入接口
	public BackJSON getTS_verify(int teacher_id) {
		BackJSON back = new BackJSON();
		for (Map<String, Object> i : teachermapper.getTS_verify(teacher_id)) {
			String student = teachermapper.getuserbyid((Long) i.get("student_id"));
			String teachet = teachermapper.getuserbyid((Long) i.get("teacher_id"));
			i.put("student", student);
			i.put("teachet", teachet);
		}
		back.setCode(200);
		back.setData(teachermapper.getTS_verify(teacher_id));
		return back;
	}
	// 教师审核学生加入接口

	public BackJSON TeacherVerifyStudent(int teacher_id, int student_id) {
		BackJSON back = new BackJSON();
		if (teachermapper.TeacherVerifyStudent(teacher_id, student_id) > 0) {
			back.setCode(200);
			back.setData("审核成功");
			return back;
		}
		back.setCode(400);
		back.setData("审核失败");
		return back;
	}

	// 老师向企业推荐学生接口
	public BackJSON TeacherRecommendStu(data_teacher data) {
		BackJSON back = new BackJSON();
		if (teachermapper.TeacherRecommendStu(data) > 0) {
			back.setCode(200);
			back.setData("操作成功");
			return back;
		}
		back.setCode(400);
		back.setData("操作失败");
		return back;
	}

}
