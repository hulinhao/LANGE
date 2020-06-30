package com.lange.game.service;/**
 * @Author linhao Hu
 * @Date 2020/6/24 0:02
 */

import com.lange.game.domian.User;
import org.springframework.stereotype.Service;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/24 0:02
 *
 */
public interface UserService {

    /**
     * 判断当前用户有是否存储
     * @param u
     */
    User checkUser(User u);

    User setName(Long userId,String name);
}
