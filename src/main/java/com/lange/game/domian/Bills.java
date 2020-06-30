package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yanankk
 */
@Data
@TableName("bills")
public class Bills {

    @TableId
    private Long id;
    private Long plateId;
    private Long userId;
    private BigDecimal amount;//下注金额
    private int type;//0:等待接单 1:未结算  2：已结算 3:已赔付
    private BigDecimal settlementAmount;//结算金额
    private Date createTime;
    private Date updateTime;
}
