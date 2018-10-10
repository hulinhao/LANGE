package com.lange.utils;

import com.lange.enums.ResponseEnum;

/**
 * 服务器响应app结果对象
 * 
 * @author lujilong
 *
 * @param <T>
 */
public class AppResponseResult {

	/**
	 * 服务器响应编号
	 */
	private String code;
	/**
	 * 服务器响应消息
	 */
	private String msg;
	/**
	 * 服务器响应结果对象
	 */
	private Object result;

	public static AppResponseResult error() {
		AppResponseResult r = new AppResponseResult();
		r.code = ResponseEnum.ERROR.getCode().toString();
		r.msg = ResponseEnum.ERROR.getMsg();
		return r;
	}

	public static AppResponseResult error(ResponseEnum e) {
		AppResponseResult r = new AppResponseResult();
		r.code = e.getCode().toString();
		r.msg = e.getMsg();
		return r;
	}

	public static AppResponseResult success() {
		return success(null);
	}

	public static AppResponseResult success(ResponseEnum e) {
		AppResponseResult r = new AppResponseResult();
		r.code = e.getCode().toString();
		r.msg = e.getMsg();
		return r;
	}

	public static AppResponseResult success(Object data) {
		AppResponseResult r = new AppResponseResult();
		if (CommUtils.isNull(data)) {
			r.code = ResponseEnum.DATA_EMPTY.getCode().toString();
			r.msg = ResponseEnum.DATA_EMPTY.getMsg();
			return r;
		}
		r.result = data;
		r.code = ResponseEnum.SUCCESS.getCode().toString();
		r.msg = ResponseEnum.SUCCESS.getMsg();
		return r;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
