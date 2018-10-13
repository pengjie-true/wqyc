package com.uporanges.mapper.student;

import java.util.List;

import com.uporanges.entity.t_student;

public interface t_studentMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(t_student record);

    int insertSelective(t_student record);

    t_student selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(t_student record);

    int updateByPrimaryKey(t_student record);
    
    List<t_student> selectall();
}