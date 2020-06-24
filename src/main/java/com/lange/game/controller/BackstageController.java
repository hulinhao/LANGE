package com.lange.game.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lange.enums.ResponseEnum;
import com.lange.game.domian.Game;
import com.lange.game.domian.Plate;
import com.lange.game.domian.Project;
import com.lange.game.domian.vo.BackstagePlateVo;
import com.lange.game.mapper.GameMapper;
import com.lange.game.mapper.PlateMapper;
import com.lange.game.mapper.ProjectMapper;
import com.lange.game.service.BackstageService;
import com.lange.utils.AppResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("backstage")
public class BackstageController {


    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private BackstageService backstageService;

    @Resource
    private GameMapper gameMapper;

    @Resource
    private PlateMapper plateMapper;


    /**
     * 后台页面
     */
    @GetMapping("")
    public String backstage() {
        return "backstage";
    }

    //项目
    @GetMapping("project")
    public String project(ModelMap map) {
        map.put("projects", projectMapper.selectList(null));
        return "project";
    }

    /**
     * 异常处理
     */
    @ExceptionHandler
    @ResponseBody
    public AppResponseResult exception(Exception e) {
        log.error("后台异常 >>{}", e.getMessage(), e);
        if (e instanceof BindException) {
            return AppResponseResult.error(ResponseEnum.PARAM_ERROR);
        }
        return AppResponseResult.errorMsg(e.getMessage());
    }

    /**
     * 比赛项目 添加
     */
    @ResponseBody
    @PostMapping("project/add")
    public AppResponseResult addProject(@Validated Project project) {
        project.setCreateTime(new Date());
        projectMapper.insert(project);
        return AppResponseResult.success();
    }

    /**
     * 比赛项目 删除
     */
    @ResponseBody
    @PostMapping("project/del")
    public AppResponseResult delProject(Long id) {
        projectMapper.deleteById(id);
        return AppResponseResult.success();
    }

    /**
     * 比赛项目 删除
     */
    @ResponseBody
    @PostMapping("project/update")
    public AppResponseResult updateProject(@Validated Project project) {
        projectMapper.updateById(project);
        return AppResponseResult.success();
    }

    //盘口
    @GetMapping("plate")
    public String plate(ModelMap map) {
        List<Project> projects = projectMapper.selectList(null);
        map.put("projects", projects);
        map.put("games", gameMapper.selectList(new LambdaQueryWrapper<Game>().eq(Game::getProjectId, projects.get(0).getId())));
        map.put("plateList", backstageService.getBackstagePlates(null, null));
        return "plate";
    }

    //盘口
    @RequestMapping("plateParam")
    public String plateParam(ModelMap map, Long paramProject, Integer paramStatus) {
        map.put("plateList", backstageService.getBackstagePlates(paramProject, paramStatus));
        return "plate::table_refresh";
    }

    //盘口
    @ResponseBody
    @PostMapping("plate/add")
    public AppResponseResult addPlate(Plate plate) {
        plate.setCreateTime(new Date());
        plateMapper.insert(plate);
        return AppResponseResult.success();
    }

    @RequestMapping("gameProject")
    public String gameProject(ModelMap map, Long projectId) {
        map.put("games", gameMapper.selectList(new LambdaQueryWrapper<Game>().eq(Game::getProjectId, projectId)));
        return "plate::game_list";
    }


}
