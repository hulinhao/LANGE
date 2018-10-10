package com.lange.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lange.entity.vo.IndexVo;
import com.lange.service.IndexService;
import com.lange.utils.AppResponseResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 首页控制器
 * 
 * @author hulinhao
 * @since JDK 1.8
 * @version 1.0
 * @description: <描述>
 */
@RestController
@RequestMapping("index/")
@Slf4j
public class IndexController {

	@Autowired
	private IndexService indexService;

	/**
	 * 查询首页所需要的信息
	 * 
	 * @return
	 */
	@RequestMapping("getCompanyInfo")
	public AppResponseResult getCompany(HttpServletRequest request) {
		try {
			IndexVo indexvo = indexService.getIndexInfo(request);
			return AppResponseResult.success(indexvo);
		} catch (Exception e) {
			e.printStackTrace();
			return AppResponseResult.error();
		}
	}
}
