package com.lange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lange.mapper.LgUserMapper;

@RestController
@RequestMapping("user/")
public class LgUserController {

	@Autowired
	private LgUserMapper lgUserMappera;

	@RequestMapping("getAllUser")
	public String getAllUser() {
		String s = lgUserMappera.getAllUser().toString();
		return s;
	}
}
