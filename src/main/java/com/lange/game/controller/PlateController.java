package com.lange.game.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lange.game.domian.Plate;
import com.lange.game.mapper.GameMapper;
import com.lange.game.mapper.PlateMapper;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/6/23 14:23
 */
@RestController
@RequestMapping("plate/")
public class PlateController {
    @Resource
    private PlateMapper platMapper;
    @Resource
    private GameMapper gameMapper;

    @RequestMapping("getPlat")
    public AppResponseResult getPlat(@RequestBody Map param){
        Map<String,Object> map = new HashMap<>(8);
        Object gameId = param.get("gameId");
        if(CommUtils.isNull(gameId)){
            return AppResponseResult.error();
        }
        map.put("game",gameMapper.selectById(Long.parseLong(gameId.toString())));
        map.put("plate",platMapper.selectList(new LambdaQueryWrapper<Plate>().eq(Plate::getGameId,Long.parseLong(gameId.toString())).eq(Plate::getType,0)));
        return AppResponseResult.success(map);
    }
}
