package com.lange.game.domian.vo;/**
 * @Author linhao Hu
 * @Date 2020/6/25 22:51
 */

import com.lange.game.domian.Project;
import lombok.Data;

import java.util.List;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/25 22:51
 *
 */
@Data
public class ProFrtPlateVo {
    private Project project;
    private List<FrtPlateVo> frtPlateVos;

    public ProFrtPlateVo(Project project){
        this.project = project;
    }
}
