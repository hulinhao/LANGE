package com.lange.game.controller;/**
 * @Author linhao Hu
 * @Date 2020/6/25 15:13
 */

import com.lange.game.domian.User;
import com.lange.game.domian.vo.UserVo;
import com.lange.game.mapper.UserMapper;
import com.lange.game.service.UserService;
import com.lange.utils.AppResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/25 15:13
 *
 */
@RestController
@RequestMapping("user/")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("saveUser")
    public AppResponseResult saveUser(@RequestBody UserVo userInfo){
        User u = new User();
        u.setWxOpenid(userInfo.getOpenId());
        u.setWxName(userInfo.getNickName());
        u.setAvatarUrl(userInfo.getAvatarUrl());
        return AppResponseResult.success(userService.checkUser(u));
    }

}
