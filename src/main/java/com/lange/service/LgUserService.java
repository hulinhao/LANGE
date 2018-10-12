package com.lange.service;

import java.util.List;

import com.lange.entity.LgCourseOrder;
import com.lange.entity.vo.UserVo;

public interface LgUserService {

	/**
	 * 查询用户信息
	 * 
	 * @param wxOpenid
	 * @return
	 */
	UserVo getUserByByUserId(String userId);

	/**
	 * 查询用户预定的课程
	 * 
	 * @param userId
	 * @return
	 */
	List<LgCourseOrder> getCourseOrderByUserId(String userId);
}
