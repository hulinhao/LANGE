package com.lange.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具
 * 
 */
public class PageUtil {

	public static int PAGE_SIZE = 7;

	public static int[] init(HttpServletRequest request) {
		String pageNoStr = request.getParameter("pageNo");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNo = CommUtils.isNull(pageNoStr) ? 1 : Integer.parseInt(pageNoStr);
		int pageSize = CommUtils.isNull(pageSizeStr) ? PageUtil.PAGE_SIZE : Integer.parseInt(pageSizeStr);
		return new int[] { pageNo, pageSize };
	}
}
