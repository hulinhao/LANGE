package com.lange.enums;

import lombok.Getter;


@Getter
public enum ResponseEnum {

	SUCCESS(200, "请求成功。"), ERROR(100, "系统错误'"), DATA_EMPTY(200, "请求成功,无返回参数"), PARAM_ERROR(102, "入参错误");

	private Integer code;
	private String msg;

	public Integer getCode(){
		return this.code;
	}
	public String getMsg(){
		return this.msg;
	}
	ResponseEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
