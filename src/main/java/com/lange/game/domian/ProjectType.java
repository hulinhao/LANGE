package com.lange.game.domian;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/8/5 15:36
 */
@Data
@TableName("project_type")
public class ProjectType {
    @TableId
    private Long id;
    private String name;
}
