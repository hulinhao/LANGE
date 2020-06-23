package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("project")
public class User {
    @TableId
    private Long id;
    private String wxAppid;
    private String wxName;
    private String name;
    private Double glod;//现有金币
    private Double payGlod;//累计充值金币
    private Double withdrawGlod;//累计提现金币
    private Date createTime;
}
