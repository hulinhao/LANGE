package com.lange.mapper;

import org.apache.ibatis.annotations.Select;

import com.lange.entity.LgCompany;

public interface LgCompanyMapper {

	@Select({ "SELECT * FROM lg_company where id = 1 " })
	LgCompany getCompanyById();
}
