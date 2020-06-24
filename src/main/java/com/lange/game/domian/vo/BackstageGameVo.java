package com.lange.game.domian.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BackstageGameVo {

    private Long id;
    private String playerOne;
    private String playerTwo;
    private Long projectId;
    private String projectRemark;
    private int type;       //0：赛前 1：赛中 2：赛后'
    private Date createTime;
    private Date endTime;


}
