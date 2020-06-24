package com.lange.game.domian.vo;

import com.lange.game.domian.Plate;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BackstagePlateVo {

    private Long plateId;
    private Long gameId;//比赛id
    private Long projectId;//项目id
    private String content;//盘口内容
    private BigDecimal odds;//赔率
    private int type;       // 1:game   2:project
    private int status; //0:可下注 1:盘口过期 3：已赔付
    private Date createTime;//
    private Date endTime;//
    private Date paidTime;//赔付时间

    //project
    private String projectRemark;

    //game
    private String playerOne;
    private String playerTwo;


}
