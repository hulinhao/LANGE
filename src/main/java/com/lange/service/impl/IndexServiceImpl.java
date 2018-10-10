package com.lange.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lange.entity.LgCompany;
import com.lange.entity.vo.IndexVo;
import com.lange.mapper.LgCompanyMapper;
import com.lange.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private LgCompanyMapper lgCompanyMapper;

	@Override
	public IndexVo getIndexInfo(HttpServletRequest request) {
		LgCompany lgCompany = lgCompanyMapper.getCompanyById(1);
		IndexVo indexVo = new IndexVo();
		indexVo.setCompanyName(lgCompany.getCompanyName());
		indexVo.setCompanyProfile(lgCompany.getCompanyProfile());

		// 获取请求域名 端口
		String url = request.getRequestURL().toString();
		String prefixUrl = url.substring(0, url.indexOf(request.getRequestURI()));

		if (prefixUrl.indexOf("https") < 1) {
			prefixUrl = prefixUrl.replaceAll("http", "https");
		}
		List<String> bannerUrl = new ArrayList<String>();
		for (String u : lgCompany.getBanner().split(";")) {
			bannerUrl.add(prefixUrl + "/banner/" + u);
		}
		indexVo.setBannerUrl(bannerUrl);
		return indexVo;
	}

}
