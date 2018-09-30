package com.lange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lange.entity.LgTeacher;
import com.lange.mapper.LgTeacherMapper;

@RestController
@RequestMapping("teacher/")
public class LgTeacherController {

	@Autowired
	private LgTeacherMapper lgTeacherMapper;

	@RequestMapping("getAllTeacher")
	public List<LgTeacher> getAllTeacher() {
		return lgTeacherMapper.getAllTeacher();
	}
}
