package com.lange.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lange.game.domian.Project;
import com.lange.game.domian.vo.BackstageProjectVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper extends BaseMapper<Project> {

    @Select({"SELECT p.id,p.img,p.`name`,p.create_time,p.remark,p.`status`,t.`name` type from project p ",
            " LEFT JOIN project_type t on p.type = t.id ORDER BY p.`status` ASC"})
    List<BackstageProjectVo> getProject();
}
