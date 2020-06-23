package com.lange.game.controller;

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
        return AppResponseResult.success(gameMapper.selectList(null));
    }
}
