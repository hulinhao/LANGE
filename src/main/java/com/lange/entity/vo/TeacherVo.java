package com.lange.entity.vo;

import lombok.Data;

@Data
public class TeacherVo {
	private Integer id;
	private String name;
	private String sex;
	private String language;
	private String explain;
	private Integer bookStatus;// -1:未预定过 0:待支付 1:已支付押金 2:已全额支付 3:已取消

}
