package com.uporanges.service.deal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uporanges.entity.Code;
import com.uporanges.mapper.deal.DealMapper;

@Service
public class DealServiceImpl implements DealService{

	@Autowired
	private DealMapper dealMapper;
	
	public List<Code> testGetAllCode() {
		return dealMapper.testGetAllCode();
	}

}
