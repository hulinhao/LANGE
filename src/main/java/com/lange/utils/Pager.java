package com.lange.utils;

import java.util.List;

import com.github.pagehelper.Page;

import lombok.Data;

@Data
public class Pager<T> {
	private Integer pageSize; // 每页数量
	private Integer pageCount;// 总页数
	private Long total; // 总数
	private Integer pageNo; // 当前页数
	private List<T> result; // 数据

	public static Pager initPage(Page page) {
		Pager p = new Pager();
		p.pageSize = page.getPageSize();
		p.pageCount = page.getPages();
		p.total = page.getTotal();
		p.pageNo = page.getPageNum();
		p.result = page.getResult();
		return p;
	}
}
