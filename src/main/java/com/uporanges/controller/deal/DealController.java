package com.uporanges.controller.deal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uporanges.entity.Code;
import com.uporanges.evo.BackJSON;
import com.uporanges.service.deal.DealService;

@Controller
@RequestMapping("/deal")
public class DealController {

	@Autowired
	private DealService dealService;
	
	@RequestMapping("/testGetAllCode")
	@ResponseBody
	public List<Code> testGetAllCode() {
		return dealService.testGetAllCode();
	}
	@GetMapping("/getTeacherInfo")
	@ResponseBody
	public BackJSON getTeacherInfo(int user_id) {
		return dealService.getTeacherInfo(user_id);
	}
	
}
