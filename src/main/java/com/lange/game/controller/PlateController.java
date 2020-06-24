package com.lange.game.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lange.game.domian.Plate;
import com.lange.game.domian.Project;
import com.lange.game.domian.vo.ProPlateVo;
import com.lange.game.mapper.GameMapper;
import com.lange.game.mapper.PlateMapper;
import com.lange.game.mapper.ProjectMapper;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Resource
    private ProjectMapper projectMapper;

    @RequestMapping("getPlat")
    public AppResponseResult getPlat(@RequestBody Map param){
        Map<String,Object> map = new HashMap<>(8);
        Object gameId = param.get("gameId");
        if(CommUtils.isNull(gameId)){
            return AppResponseResult.error();
        }
        map.put("game",gameMapper.selectById(Long.parseLong(gameId.toString())));
        map.put("plate",platMapper.selectList(new LambdaQueryWrapper<Plate>().eq(Plate::getGameId,Long.parseLong(gameId.toString())).eq(Plate::getStatus,0)));
        return AppResponseResult.success(map);
    }

    @RequestMapping("getProPlate")
    public AppResponseResult getProPlate(){
        List<ProPlateVo> pp = new ArrayList<ProPlateVo>();
        List<Project> projectList = projectMapper.selectList(new LambdaQueryWrapper<Project>().eq(Project::getStatus,0));
        for (int i=0;i<projectList.size();i++){
            Project p = projectList.get(i);
            List<Plate> plates = platMapper.selectList(new LambdaQueryWrapper<Plate>()
                    .eq(Plate::getProjectId,p.getId()).eq(Plate::getType,2).eq(Plate::getStatus,0));
            ProPlateVo pv = new ProPlateVo();
            pv.setProject(p);
            pv.setPlates(plates);
            pp.add(pv);
        }
        return AppResponseResult.success(pp);
    }
}
