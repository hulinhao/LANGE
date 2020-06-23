package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("plate")
public class Plate {

    @TableId
    private Long id;
    private Long gameId;//比赛id
    private String content;//盘口内容
    private BigDecimal odds;//赔率
    private Integer type;//0:可下注 1:盘口过期 3：已赔付
    private Date createTime;//
    private Date endTime;//
    private Date paidTime;//赔付时间
}
