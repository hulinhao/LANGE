package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String wxOpenid;
    private String wxName;
    private String name;
    private BigDecimal gold;//现有金币
    private BigDecimal payGold;//累计充值金币
    private BigDecimal withdrawGold;//累计提现金币
    private Date createTime;
    private Date updateTime;

}
