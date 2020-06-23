package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author yanankk
 */
@Data
@TableName("game")
public class Game {

    @TableId
    private Long id;
    private String playerOne;
    private String playerTwo;
    private Long projectId;
    private int type;       //0：赛前 1：赛中 2：赛后'
    private Date createTime;
    private Date endTime;
}
