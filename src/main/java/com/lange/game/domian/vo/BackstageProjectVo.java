package com.lange.game.domian.vo;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/8/5 15:18
 */
@Data
public class BackstageProjectVo {
    private  Long id;
    private String img;
    private String name;
    private Date createTime;
    private String remark;
    private int status;//0:进行中  1:完结
    private String type; //项目类型名称
}
