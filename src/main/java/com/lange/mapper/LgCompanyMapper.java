package com.lange.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lange.entity.LgCompany;

@Mapper
public interface LgCompanyMapper {

	@Select({ "SELECT * FROM lg_company where id = #{id} " })
	LgCompany getCompanyById(@Param("id") Integer id);
}
