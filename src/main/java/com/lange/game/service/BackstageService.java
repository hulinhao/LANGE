package com.lange.game.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lange.game.domian.Game;
import com.lange.game.domian.Plate;
import com.lange.game.domian.Project;
import com.lange.game.domian.vo.BackstageGameVo;
import com.lange.game.domian.vo.BackstagePlateVo;
import com.lange.game.mapper.GameMapper;
import com.lange.game.mapper.PlateMapper;
import com.lange.game.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BackstageService {


    @Resource
    private PlateMapper plateMapper;

    @Resource
    private GameMapper gameMapper;

    @Resource
    private ProjectMapper projectMapper;


    /**
     * 封装盘口信息
     */
    public List<BackstagePlateVo> getBackstagePlates(Long paramProject, Integer paramStatus) {
        List<BackstagePlateVo> list = new ArrayList<>();
        List<Plate> plates = plateMapper.selectList(new LambdaQueryWrapper<Plate>().eq(paramProject != null, Plate::getProjectId, paramProject).eq(paramStatus != null && paramStatus != 0, Plate::getStatus, paramStatus));
        for (Plate plate : plates) {
            BackstagePlateVo vo = new BackstagePlateVo();
            BeanUtils.copyProperties(plate, vo);
            vo.setProjectRemark(projectMapper.selectById(plate.getProjectId()).getRemark());
            vo.setPlateId(plate.getId());
            if (plate.getType() == 1) {
                //关联
                Game game = gameMapper.selectById(plate.getGameId());
                vo.setPlayerOne(game.getPlayerOne());
                vo.setPlayerTwo(game.getPlayerTwo());
            }
            list.add(vo);
        }
        return list;
    }

    /**
     * 封装赛程
     */
    public List<BackstageGameVo> getBackstageGame(Long paramProject) {
        List<BackstageGameVo> list = new ArrayList<>();
        List<Game> games = gameMapper.selectList(new LambdaQueryWrapper<Game>().eq(paramProject != null, Game::getProjectId, paramProject));

        for (Game game : games) {
            BackstageGameVo vo = new BackstageGameVo();
            BeanUtils.copyProperties(game, vo);
            vo.setProjectRemark(projectMapper.selectById(game.getProjectId()).getRemark());
            list.add(vo);
        }
        return list;
    }
}
