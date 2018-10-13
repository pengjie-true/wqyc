package com.uporanges.mapper.current;

import com.uporanges.entity.t_user;

public interface t_userMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(t_user record);

    int insertSelective(t_user record);

    t_user selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(t_user record);

    int updateByPrimaryKey(t_user record);
}