package com.lange.game.domian.vo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/6/30 15:52
 */
@Data
public class ProBillsVo {
    private Long projectId;
    private List<BillsInfo> billsInfos;
}