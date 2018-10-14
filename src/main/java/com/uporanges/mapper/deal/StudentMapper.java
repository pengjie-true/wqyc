package com.uporanges.mapper.deal;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.uporanges.entity.Student;

public interface StudentMapper {

	@InsertProvider(type=StudentProvider.class, method="addStudent")
	int addStudent(Student student);
	@UpdateProvider(type=StudentProvider.class, method="alterStudent")
	int alterStudent(Student student);
	
}
