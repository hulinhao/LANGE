package com.lange.game.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lange.game.domian.Game;
import com.lange.game.mapper.GameMapper;
import com.lange.utils.AppResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author linhao Hu
 * @date 2020-06-23
 *
 */
@RestController
@RequestMapping("game/")
public class GameController {

    @Resource
    private GameMapper gameMapper;

    @RequestMapping("getGameList")
    public AppResponseResult getGameList(){
        //查询所有未完结比赛 type:0
        return AppResponseResult.success(gameMapper.getGameInfo());
    }
}
