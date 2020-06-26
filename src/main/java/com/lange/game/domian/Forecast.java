package com.lange.game.domian;/**
 * @Author linhao Hu
 * @Date 2020/6/25 21:54
 */

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/25 21:54
 *
 */
@Data
@TableName("forecast")
public class Forecast {
    @TableId
    private Long id;
    private Long gameId;
    private Long projectId;
    private int relate;//'1:关联项目   2：关联比赛',
    private int type;//'1:单盘  2：多盘',
    private String content;//'预测内容',
    private Date createTime;

}
