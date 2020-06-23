package com.lange.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/6/23 12:41
 */
@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long plateId;
    private Long userId;
    private Double amount;//下注金额
    private int type;//0:未结算  1：已结算
    private Double settlementAmount;//结算金额
    private Date createTime;
    private Date updateTime;
}
