package com.lange.entity;

import java.util.Date;

import lombok.Data;

@Data
public class LgTeacher {
	private Long id;
	private String name;
	private int sex;
	private int teachTime; // 教学时长 单位：年
	private int type; // '教学科目 0:英语 1:汉语 3:日语'
	private String explain; // '老师介绍'
	private Date registTime;// 平台注册时间
	private Date createTime;
	private Date updateTime;
}
