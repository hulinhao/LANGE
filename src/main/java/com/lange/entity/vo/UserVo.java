package com.lange.entity.vo;

import lombok.Data;

@Data
public class UserVo {
	private Long id;
	private String wexinOpenid;
	private String name;
	private String phone;
	private String adress;
	private Integer sex;// 0:女 1::男
	private String personalProfile;
	private Integer role; // '1:学生 2:老师'
	private String signature;
	private String photo;
	private String level;
}
