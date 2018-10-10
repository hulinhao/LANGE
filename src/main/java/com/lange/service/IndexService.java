package com.lange.service;

import javax.servlet.http.HttpServletRequest;

import com.lange.entity.vo.IndexVo;

public interface IndexService {

	IndexVo getIndexInfo(HttpServletRequest request);
}
