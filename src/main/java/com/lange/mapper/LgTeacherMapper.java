package com.lange.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lange.entity.LgTeacher;

@Mapper
public interface LgTeacherMapper {

	@Select({ "select * from lg_teacher" })
	// 查询所有老师
	List<LgTeacher> getAllTeacher();
}
