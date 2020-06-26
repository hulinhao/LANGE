package com.lange.game.domian.vo;

import com.lange.game.domian.Forecast;
import com.lange.game.domian.Plate;
import com.lange.game.domian.Project;
import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/6/24 16:46
 */
@Data
public class FrtPlateVo {
    private Forecast forecast;
    private List<Plate> plates;

    public FrtPlateVo(Forecast forecast){
        this.forecast = forecast;
    }
}
