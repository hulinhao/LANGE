package com.lange.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lange.enums.ResponseEnum;
import com.lange.service.LgUserService;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;

@RestController
@RequestMapping("user/")
public class LgUserController {

	@Autowired
	private LgUserService userService;

	// 查询用户信息
	@RequestMapping("getUserInfo")
	public AppResponseResult getUserInfo(HttpServletRequest request) {
		try {
			String userId = request.getParameter("userId");
			if (CommUtils.isNull(userId)) {
				return AppResponseResult.error(ResponseEnum.PARAM_ERROR);
			}
			return AppResponseResult.success(userService.getUserByByUserId(userId));

		} catch (Exception e) {
			e.printStackTrace();
			return AppResponseResult.error();
		}
	}

	// 查询当前用户已经预定的课程
	@RequestMapping("getHasBookCourse")
	public AppResponseResult getHasBookCourse(HttpServletRequest request) {
		try {
			String userId = request.getParameter("userId");
			if (CommUtils.isNull(userId)) {
				return AppResponseResult.error(ResponseEnum.PARAM_ERROR);
			}
			return AppResponseResult.success(userService.getCourseOrderByUserId(userId));

		} catch (Exception e) {
			e.printStackTrace();
			return AppResponseResult.error();
		}
	}

	// 获取广告
	@RequestMapping("getADs")
	public AppResponseResult getADs() {
		return null;
	}
}
