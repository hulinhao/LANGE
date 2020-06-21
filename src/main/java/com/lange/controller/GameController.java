package com.lange.controller;

import com.lange.entity.Game;
import com.lange.mapper.GameMapper;
import com.lange.utils.AppResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author linhao Hu
 * @Date
 *
 */
@RestController
@RequestMapping("game/")
public class GameController {

    @Resource
    private GameMapper gameMapper;

    @RequestMapping("getGameList")
    public AppResponseResult getGameList(){
        return AppResponseResult.success(gameMapper.selectAll());
    }
}
