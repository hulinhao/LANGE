package com.lange.game.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lange.game.domian.Forecast;
import com.lange.game.domian.Plate;
import com.lange.game.domian.Project;
import com.lange.game.domian.vo.FrtPlateVo;
import com.lange.game.domian.vo.GameFrtPlateVo;
import com.lange.game.domian.vo.ProFrtPlateVo;
import com.lange.game.mapper.ForecastMapper;
import com.lange.game.mapper.GameMapper;
import com.lange.game.mapper.PlateMapper;
import com.lange.game.mapper.ProjectMapper;
import com.lange.utils.AppResponseResult;
import com.lange.utils.CommUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PlateController {
    @Resource
    private PlateMapper platMapper;
    @Resource
    private GameMapper gameMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private ForecastMapper forecastMapper;

    /**
     * 根据gameId查询盘口
     * @param param
     * @return
     */
    @RequestMapping("getGamePlate")
    public AppResponseResult getPlat(@RequestBody Map param){
        Map<String,Object> map = new HashMap<>(8);
        Object gameId = param.get("gameId");
        if(CommUtils.isNull(gameId)){
            return AppResponseResult.error();
        }
        List<FrtPlateVo> frtPlateVos = new ArrayList<FrtPlateVo>();
        //获取当前赛事预测信息
        List<Forecast> forecastList = forecastMapper.selectList(new LambdaQueryWrapper<Forecast>()
                .eq(Forecast::getGameId,Long.parseLong(gameId.toString())).eq(Forecast::getRelate,1));
        //循环查询盘口
        for (Forecast ft:forecastList) {
            FrtPlateVo vo = new FrtPlateVo(ft);
            List<Plate> plateList = platMapper.selectList(new LambdaQueryWrapper<Plate>().eq(Plate::getStatus,0).eq(Plate::getForecastId,ft.getId()));
            vo.setPlates(plateList);
            frtPlateVos.add(vo);
        }
        GameFrtPlateVo gameFrtPlateVo = new GameFrtPlateVo(gameMapper.getGameInfoByGameId(Long.parseLong(gameId.toString())));
        gameFrtPlateVo.setFrtPlateVos(frtPlateVos);
        log.info("查询比赛盘口信息：{}",gameFrtPlateVo.toString());
        return AppResponseResult.success(gameFrtPlateVo);
    }

    /**
     * 查询所有未完结项目盘口
     * @return
     */
    @RequestMapping("getProPlate")
    public AppResponseResult getProPlate(){
        List<ProFrtPlateVo> proFrtPlateVoList = new ArrayList<>();
        List<Project> projectList = projectMapper.selectList(new LambdaQueryWrapper<Project>().eq(Project::getStatus,0));
        for (Project p : projectList){
            ProFrtPlateVo proFrtPlateVo = new ProFrtPlateVo(p);
            //获取当前项目预测信息
            List<Forecast> forecastList = forecastMapper.selectList(new LambdaQueryWrapper<Forecast>().eq(Forecast::getProjectId,p.getId()).eq(Forecast::getRelate,2));
            //循环查询盘口
            List<FrtPlateVo> frtPlateVoList = new ArrayList<>();
            for (Forecast ft : forecastList) {
                FrtPlateVo vo = new FrtPlateVo(ft);
                List<Plate> plateList = platMapper.selectList(new LambdaQueryWrapper<Plate>().eq(Plate::getStatus,0).eq(Plate::getForecastId,ft.getId()));
                vo.setPlates(plateList);
                frtPlateVoList.add(vo);
            }
            proFrtPlateVo.setFrtPlateVos(frtPlateVoList);
            proFrtPlateVoList.add(proFrtPlateVo);
        }
        log.info("查询所有项目盘口信息：{}",proFrtPlateVoList.toString());
        return AppResponseResult.success(proFrtPlateVoList);
    }
}
