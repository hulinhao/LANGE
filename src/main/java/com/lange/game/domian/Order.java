package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author yanankk
 */
@Data
@TableName("order")
public class Order {

    @TableId
    private Long id;
    private Long plateId;
    private Long userId;
    private Double amount;//下注金额
    private int type;//0:未结算  1：已结算
    private Double settlementAmount;//结算金额
    private Date createTime;
    private Date updateTime;
}
