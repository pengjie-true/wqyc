package com.uporanges.serviceImpl.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uporanges.entity.t_student;
import com.uporanges.mapper.student.t_studentMapper;
import com.uporanges.service.student.userservice;


@Service
public class userserviceImpl implements userservice{

	
	@Autowired
	t_studentMapper tm;
	public List<t_student> selectall() {
		// TODO Auto-generated method stub
		return tm.selectall();
	}




}
