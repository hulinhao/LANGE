package com.lange.entity;

import java.util.Date;

import lombok.Data;

@Data
public class LgCourseOrder {
	private Long id;
	private Long userId;// '预订人id',
	private String userWx;// '预订人微信',
	private String courseName;// '课程名称',
	private Long courseId;// '课程id ',
	private Long teacherId;// '授课老师id ',
	private Integer number;// '预订数量',
	private Double totalAmount;// '总金额',
	private Double discountAmount;// '折扣金额',
	private Double payableAmount;// '应付金额',
	private Double paidAmount;// '已支付金额',
	private int type;// '订单状态 0:待支付 1:已支付押金 2:已全额支付 3:已取消',
	private Date createTime;
	private Date updateTime;

}
