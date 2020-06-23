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
 * @date 2020/6/23 11:59
 */
@Entity
@Data
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gameId;//比赛id
    private String content;//盘口内容
    private Double odds;//赔率
    private Integer type;//0:可下注 1:盘口过期 3：已赔付
    private Date createTime;//
    private Date endTime;//
    private Date paidTime;//赔付时间
}
