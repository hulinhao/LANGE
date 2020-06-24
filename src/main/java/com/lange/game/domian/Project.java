package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("project")
public class Project {
    @TableId
    private Long id;
    @NotBlank
    private String name;
    private int type; //'1：台球   2：篮球'
    private String img;  //图片
    @NotBlank
    private String remark; //备注
    private int status;
    private Date createTime;
}
