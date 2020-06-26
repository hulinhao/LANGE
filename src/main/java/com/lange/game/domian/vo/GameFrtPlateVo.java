package com.lange.game.domian.vo;/**
 * @Author linhao Hu
 * @Date 2020/6/25 22:53
 */

import com.lange.game.domian.Game;
import lombok.Data;

import java.util.List;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/25 22:53
 *
 */
@Data
public class GameFrtPlateVo {
    private GameVo gameVo;
    private List<FrtPlateVo> frtPlateVos;

    public GameFrtPlateVo(GameVo gameVo){
        this.gameVo = gameVo;
    }
}
