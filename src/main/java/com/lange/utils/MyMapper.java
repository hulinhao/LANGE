package com.lange.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Desc: mapper基础类
 * Author: dushuang
 * Date: Create in 2018/4/3
 */
public interface MyMapper<T> extends Mapper<T> , MySqlMapper<T> {
}
