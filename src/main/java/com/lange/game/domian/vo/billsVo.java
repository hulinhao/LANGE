package com.lange.game.domian.vo;/**
 * @Author linhao Hu
 * @Date 2020/6/23 20:46
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @Author linhao Hu
 * @Date 2020/6/23 20:46
 *
 */
@Data
public class billsVo {
    private Long plateId;
    private Long userId;
    private BigDecimal amount;//下注金额
}
