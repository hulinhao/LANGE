package com.lange.game.domian.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/6/30 15:35
 */
@Data
public class PaidBillsVo {
    private Long userId;
    private BigDecimal paidAmount;
    private List<ProBillsVo> proBillsVos;
}
