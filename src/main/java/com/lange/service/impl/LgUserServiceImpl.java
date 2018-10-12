package com.lange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lange.entity.LgCourseOrder;
import com.lange.entity.vo.UserVo;
import com.lange.mapper.LgUserMapper;
import com.lange.service.LgUserService;

@Service
public class LgUserServiceImpl implements LgUserService {

	@Autowired
	private LgUserMapper userMapper;

	@Override
	public UserVo getUserByByUserId(String userId) {
		return userMapper.getUserByByUserId(userId);
	}

	@Override
	public List<LgCourseOrder> getCourseOrderByUserId(String userId) {
		return userMapper.getCourseOrder(userId);
	}

}
