package com.lange.game.domian.vo;/**
 * @Author linhao Hu
 * @Date 2020/6/25 2:13
 */

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/25 2:13
 *
 */
@Data
public class GameVo implements Serializable {
    private Long id;
    private String playerOne;
    private String playerTwo;
    private Long projectId;
    private int type;       //0：赛前 1：赛中 2：赛后'
    private Date createTime;
    private Date endTime;
    private String imgName;
}
