package com.lange.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lange.entity.LgTeacher;
import com.lange.entity.vo.CourseVo;
import com.lange.entity.vo.TeacherVo;

@Mapper
public interface LgTeacherMapper {

	// 根据id 查询老师详细信息
	@Select({ "select * from lg_teacher where id = #{id}" })
	LgTeacher getTeacherById(@Param("id") String id);

	// 查询所有老师
	@Select({ "<script> select t.id id,t.`name` name,t.sex sex,l.`language` `language`,t.`explain` `explain`, ",
			" IFNULL((select b.type  from lg_course_book b where b.teacher_id = t.id and b.user_wx = #{wxOpenid}),-1) bookStatus ",
			" from lg_teacher t LEFT JOIN lg_language l on t.language_id = l.id </script>" })
	List<TeacherVo> getTeacherlist(@Param("wxOpenid") String wx_openid);

	/**
	 * 根据老师id 查询课程信息
	 * 
	 * @param teacherId
	 * @return
	 */
	@Select({
			"select c.course_name courseName,c.price price,c.course_hour courseHour,l.`language` language,c.study_num studyNum ",
			" from lg_course c LEFT JOIN lg_teacher_course tc on c.id = tc.course_id LEFT JOIN lg_language l on c.language_id = l.id ",
			" where tc.teacher_id =#{teacherId}  and c.is_effective = 0;" })
	CourseVo getCourseInfo(@Param("teacherId") String teacherId);
}