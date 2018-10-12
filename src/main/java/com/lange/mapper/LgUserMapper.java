package com.lange.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lange.entity.LgCourseOrder;
import com.lange.entity.vo.UserVo;

@Mapper
public interface LgUserMapper {

	/**
	 * 查询用户信息
	 * 
	 * @param wxOpenid
	 * @return
	 */
	@Select({ "select * from lg_user where id = #{userId}" })
	UserVo getUserByByUserId(@Param("userId") String userId);

	/**
	 * 查询用户预定的课程
	 * 
	 * @param userId
	 * @return
	 */
	@Select({ "select * FROM lg_course_order o where o.user_id = #{userId}" })
	List<LgCourseOrder> getCourseOrder(@Param("userId") String userId);
}
