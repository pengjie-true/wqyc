package com.uporanges.service.deal;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.uporanges.entity.Student;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.StudentInfo;
import com.uporanges.mapper.deal.StudentMapper;
import com.uporanges.util.Value;

@Service
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	public int addStudent(Student student) {
		long now = System.currentTimeMillis();
		student.setStu_createdtime(new Date(now));
		student.setStu_status(1);
		student.setIs_mobile_check(1);
		student.setLast_login_time(new Timestamp(now));
		return studentMapper.addStudent(student);
	}
	@Transactional
	public Map<String, Object> addUserStudent(User user, Student student) {
		Map<String, Object> result = new HashMap<String, Object>();
		MultipartFile pic = user.getUser_pic();
		result.put("code", 400);
		if(studentMapper.addUser(user)==1) {
			int user_id = user.getUser_id();
			//写入用户头像
			if(pic!=null) {
				String path = Value.getUserpicpath();
				//文件名字： 1+1539663242037+pic.jpg
				String fileName = user.getUser_id()+"+"+System.currentTimeMillis()+"+"+pic.getOriginalFilename();
				File file = new File(path+File.separator+fileName);
				try {
					pic.transferTo(file);
					studentMapper.addUserPicture(user_id, fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			student.setUser(user);
			if(studentMapper.addStudent(student)==1)
			{
				result.replace("code", 200);
				result.put("user_id", user_id);
			}
		}
		return result;
	}
	public int alterStudent(Student student) {
		return studentMapper.alterStudent(student);
	}
	public BackJSON getStudentInfo(String user_id) {
		BackJSON json = new BackJSON();
		json.setCode(200);
		StudentInfo studentInfo = studentMapper.getStudentInfo(user_id);
		if(studentInfo!=null) 
			json.setData(studentInfo);
		else 
			json.setCode(400);
		return json;
	}
	public boolean ifPhoneIn(String phone) {
		if(studentMapper.getUseridName(phone)!=null)
			return true;
		return false;
	}
	public boolean ifeMailIn(String email) {
		if(studentMapper.getStudentIdName(email)!=null)
			return true;
		return false;
	}

}
