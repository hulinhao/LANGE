package com.lange.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lange.game.domian.Game;
import com.lange.game.domian.vo.GameVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameMapper extends BaseMapper<Game> {

    /**
     * 查询所有未完结的比赛信息
     * @return
     */
    @Select({"select g.*,p.img imgName from game g LEFT JOIN project p on g.project_id = p.id where p.`status`=0 and g.type = 0 "})
    List<GameVo> getGameInfo();


    @Select({"select g.*,p.img imgName from game g LEFT JOIN project p on g.project_id = p.id where p.`status`=0 and g.type = 0 and g.id = #{id} limit 1"})
    GameVo getGameInfoByGameId(Long id);
}
