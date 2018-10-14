package com.uporanges.service.deal;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uporanges.entity.Student;
import com.uporanges.mapper.deal.StudentMapper;

@Service
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
	public int alterStudent(Student student) {
		return studentMapper.alterStudent(student);
	}

}
