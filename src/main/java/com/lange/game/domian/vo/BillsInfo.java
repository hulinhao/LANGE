package com.lange.game.domian.vo;/**
 * @Author linhao Hu
 * @Date 2020/6/27 23:02
 */

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/27 23:02
 *
 */
@Data
public class BillsInfo {

    private Long billsId;
    private BigDecimal amount;
    private int billsType; //0:等待接单 1:未结算  2：已结算
    private String proName;
    private String proRemark;
    private String pone;
    private String ptwo;
    private BigDecimal odds;
    private String plateContent;
    private String forecastContent;
    private int forecastType; //1:单盘  2：多盘
    private int relate; //1：关联比赛 2:关联项目
    private String name;
    private String wxName;

}
