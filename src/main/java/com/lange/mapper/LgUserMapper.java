package com.lange.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LgUserMapper {

	@Select({ "select * from lg_user " })
	List<Map<String, String>> getAllUser();

}
