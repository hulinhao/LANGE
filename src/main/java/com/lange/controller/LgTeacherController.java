package com.lange.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lange.entity.vo.TeacherVo;
import com.lange.enums.ResponseEnum;
import com.lange.service.LgTeacherService;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;
import com.lange.utils.PageUtil;
import com.lange.utils.Pager;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("teacher/")
@Slf4j
public class LgTeacherController {
	@Autowired
	private LgTeacherService teacherService;

	/**
	 * 
	 * 查询教师列表
	 * 
	 * @return
	 */
	@RequestMapping("getAllTeacher")
	public AppResponseResult getTeacherList(HttpServletRequest request) {
		try {
			String wxOpenid = request.getParameter("wx_openid");
			if (CommUtils.isNull(wxOpenid)) {
				AppResponseResult.error(ResponseEnum.PARAM_ERROR);
			}
			Pager<TeacherVo> page = teacherService.getTeacherList(wxOpenid, PageUtil.init(request));
			return AppResponseResult.success(page);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("【查询教师列表】 系统错误。");
			return AppResponseResult.error();
		}
	}

	/**
	 * 查询教师详细信息
	 * 
	 * @return
	 */
	@RequestMapping("getTeacherInfo")
	public AppResponseResult getTeacherInfo(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			if (CommUtils.isNull(id)) {
				log.info("【查询老师详细信息】老师id为空!");
				return AppResponseResult.error(ResponseEnum.PARAM_ERROR);
			}
			return AppResponseResult.success(teacherService.findTeacherById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return AppResponseResult.error();
		}
	}

	/**
	 * 查询老师的课程信息
	 * 
	 * @return
	 */
	@RequestMapping("getCourseInfo")
	public AppResponseResult getCourseInfo(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			if (CommUtils.isNull(id)) {
				log.info("【查询课程信息】 老师id为空!");
				return AppResponseResult.error(ResponseEnum.PARAM_ERROR);
			}
			return AppResponseResult.success(teacherService.getCourseInfo(id));
		} catch (Exception e) {
			e.printStackTrace();
			return AppResponseResult.error();
		}
	}

	/**
	 * 预订课程
	 * 
	 * @return
	 */
	@RequestMapping("bookCourse")
	public AppResponseResult bookCourse() {
		return null;
	}
}
