package com.lange.game.controller;

import java.util.HashMap;
import java.util.Map;

import com.lange.game.domian.User;
import com.lange.game.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lange.utils.AesCbcUtil;
import com.lange.utils.HttpRequest;

import javax.annotation.Resource;

/**
 *
 * @Author linhao Hu
 * @Date
 *
 */
@Controller
@RequestMapping("winxin/")
@Slf4j
public class WeixinController {

	@Resource
	private UserService userService;

	/**
	 * @Title: decodeUserInfo        
	 * @Description: 解密用户敏感数据
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "decodeUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map decodeUserInfo(@RequestBody Map<String,String> param) {

		//encryptedData 明文,加密数据
		String encryptedData = param.get("encryptedData");
		//iv 加密算法的初始向量
		String iv = param.get("iv");
		//code 用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid和session_key
		String code = param.get("code");

		Map map = new HashMap();
		// 登录凭证不能为空
		if (code == null || code.length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}

		// 小程序唯一标识 (在微信小程序管理后台获取)
		String wxspAppid = "wxf7bada46fbe07dc8";
		// 小程序的 app secret (在微信小程序管理后台获取)
		String wxspSecret = "64e8f82ed4fc3aa2645baea3693e65a7";
		// 授权（必填）
		String grant_type = "authorization_code";

		//////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
		//////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
		try {
			// 请求参数
			String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
					+ grant_type;
			// 发送请求
			String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
			// 解析相应内容（转换成json对象）
			JSONObject json = new JSONObject(sr);
			// 获取会话密钥（session_key）
			String session_key = json.get("session_key").toString();
			// 用户的唯一标识（openid）
			String openid = (String) json.get("openid");
			// 参数含义：第一个，加密数据串（String）；第二个，session_key需要通过微信小程序的code获得（String）；
			// 第三个，数据加密时所使用的偏移量，解密时需要使用（String）；第四个，编码
			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
			//用户数据加密
			if (null != result && result.length() > 0) {
				map.put("status", 1);
				map.put("msg", "解密成功");

				JSONObject userInfoJSON = new JSONObject(result);
				Map userInfo = new HashMap();
				userInfo.put("openId", userInfoJSON.get("openId"));
				userInfo.put("nickName", userInfoJSON.get("nickName"));
				userInfo.put("gender", userInfoJSON.get("gender"));
				userInfo.put("city", userInfoJSON.get("city"));
				userInfo.put("province", userInfoJSON.get("province"));
				userInfo.put("country", userInfoJSON.get("country"));
				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
				// 解密unionId & openId;
				//拿不到
				//userInfo.put("unionId", userInfoJSON.get("unionId"));
				//map.put("userInfo", userInfo);

				//判断当前登录用户是否表中存在
				User u = new User();
				u.setWxOpenid(userInfoJSON.get("openId").toString());
				u.setWxName(userInfoJSON.get("nickName").toString());
				u.setAvatarUrl(userInfo.get("avatarUrl").toString());
				map.put("user",userService.checkUser(u));
			} else {
				map.put("status", 0);
				map.put("msg", "解密失败");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		log.info("用户:{}",map.toString());
		return map;
	}
}
