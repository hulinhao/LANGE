package com.lange.service;

import com.lange.entity.LgTeacher;
import com.lange.entity.vo.CourseVo;
import com.lange.entity.vo.TeacherVo;
import com.lange.utils.Pager;

public interface LgTeacherService {

	/**
	 * 查询老师列表
	 * 
	 * @param wx_openid 当前用户微信
	 * @return
	 */
	Pager<TeacherVo> getTeacherList(String userId, int[] page);

	/**
	 * 根据id 查询老师详情
	 * 
	 * @param id
	 * @return
	 */
	LgTeacher findTeacherById(String id);

	/**
	 * 查询老师课程信息
	 * 
	 * @param teacherId
	 * @return
	 */
	CourseVo getCourseInfo(String teacherId);
}
