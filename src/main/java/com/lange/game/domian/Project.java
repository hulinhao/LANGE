package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("project")
public class Project {
    @TableId
    private Long id;
    private String name;
    private int type; //'1：台球   2：篮球'
    private String img;  //图片
    private String remark; //备注
    private Date createTime;
}
