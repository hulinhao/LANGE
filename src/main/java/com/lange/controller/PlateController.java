package com.lange.controller;

import com.lange.entity.Plate;
import com.lange.mapper.GameMapper;
import com.lange.mapper.PlatMapper;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private PlatMapper platMapper;
    @Resource
    private GameMapper gameMapper;

    @RequestMapping("getPlat")
    public AppResponseResult getPlat(@RequestBody Map param){
        Map<String,Object> map = new HashMap<String,Object>();
        Object gameId = param.get("gameId");
        if(CommUtils.isNull(gameId)){
            return AppResponseResult.error();
        }
        Plate p = new Plate();
        p.setGameId(Long.parseLong(gameId.toString()));
        p.setType(0);
        map.put("game",gameMapper.selectByPrimaryKey(Long.parseLong(gameId.toString())));
        map.put("plate",platMapper.select(p));
        return AppResponseResult.success(map);
    }
}
