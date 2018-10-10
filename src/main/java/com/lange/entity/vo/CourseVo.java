package com.lange.entity.vo;

import lombok.Data;

@Data
public class CourseVo {
	private String courseName;
	private Double price;
	private Integer courseHour;
	private String language;
	private Integer studyNum;
}
