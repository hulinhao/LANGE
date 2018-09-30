package com.lange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lange.entity.LgCompany;
import com.lange.mapper.LgCompanyMapper;

@RestController
@RequestMapping("index/")
public class IndexController {
	@Autowired
	private LgCompanyMapper lgCompanyMapper;

	@RequestMapping("getCompanyInfo")
	public LgCompany getCompany() {
		return lgCompanyMapper.getCompanyById();
	}
}
