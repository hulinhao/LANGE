package com.lange.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lange.game.domian.Bills;
import com.lange.game.domian.vo.BillsInfo;
import com.lange.game.domian.vo.BillsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillsMapper extends BaseMapper<Bills> {

    @Select({" SELECT" +
            " b.id billsId,b.amount amount,b.type billsType,pro.`name` proName,pro.remark proRemark,g.player_one pone,g.player_two ptwo," +
            " p.odds odds,p.content plateContent,f.content forecastContent,f.type forecastType,f.relate relate" +
            " FROM" +
            " bills b " +
            " LEFT JOIN plate p ON b.plate_id = p.id" +
            " LEFT JOIN forecast f ON f.id = p.forecast_id" +
            " LEFT JOIN game g ON g.id = f.game_id " +
            " LEFT JOIN project pro on  pro.id = f.project_id" +
            " where b.user_id = #{userId}" +
            " GROUP BY" +
            " b.id ORDER BY b.type,update_time" })
    List<BillsInfo> getBillsByuserId(@Param("userId") Long userId);
}