package com.lange.entity;

import lombok.Data;

@Data
public class LgTeacher {
	private Long id;
	private String name;
	private String sex;
	private int teachTime; // 教学时长 单位：年
	private String language; // '教学科目
	private String explain; // '老师介绍'
	private String registTime;// 平台注册时间
	private String createTime;
	private String updateTime;
}
