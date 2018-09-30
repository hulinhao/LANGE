package com.lange.entity;

import java.util.Date;

import lombok.Data;

@Data
public class LgCompany {

	private Long id;
	// 公司名称
	private String companyName;
	// 公司简介
	private String companyProfile;
	// banner图
	private String banner;
	// 公司法人
	private String companyLegalPerson;
	// 公司注册时间
	private Date registrationTime;
	private Date createTime;
	private Date updateTime;

}
