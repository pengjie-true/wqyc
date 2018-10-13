package com.uporanges.mapper.company;

import com.uporanges.entity.t_company;

public interface t_companyMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(t_company record);

    int insertSelective(t_company record);

    t_company selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(t_company record);

    int updateByPrimaryKeyWithBLOBs(t_company record);

    int updateByPrimaryKey(t_company record);
}