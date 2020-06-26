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
    private String avatarUrl;
    private String name;
    private int type;// 0:客户 1:管理赛程  2:管理赔率，金币
    private BigDecimal gold;//现有金币
    private BigDecimal payGold;//累计充值金币
    private BigDecimal withdrawGold;//累计提现金币
    private Date createTime;
    private Date updateTime;

}
