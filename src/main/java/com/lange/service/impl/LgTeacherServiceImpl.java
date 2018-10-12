package com.lange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lange.entity.LgTeacher;
import com.lange.entity.vo.CourseVo;
import com.lange.entity.vo.TeacherVo;
import com.lange.mapper.LgTeacherMapper;
import com.lange.service.LgTeacherService;
import com.lange.utils.CommUtils;
import com.lange.utils.Pager;

@Service
public class LgTeacherServiceImpl implements LgTeacherService {
	@Autowired
	private LgTeacherMapper lgTeacherMapper;

	@Override
	public Pager<TeacherVo> getTeacherList(String userId, int[] pagePram) {
		Pager<TeacherVo> pager = new Pager<TeacherVo>();
		// 1.查询老师基本信息
		// 2.查询是否已经预订过该老师的课程
		if (CommUtils.isNull(userId)) {
			userId = "-1";
		}
		Page<TeacherVo> page = PageHelper.startPage(pagePram[0], pagePram[1], true);
		lgTeacherMapper.getTeacherlist(userId);

		return pager.initPage(page);

	}

	@Override
	public LgTeacher findTeacherById(String id) {
		return lgTeacherMapper.getTeacherById(id);
	}

	@Override
	public CourseVo getCourseInfo(String teacherId) {
		return lgTeacherMapper.getCourseInfo(teacherId);
	}

}
