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
 * @date 2020/6/23 12:46
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wxAppid;
    private String wxName;
    private String name;
    private Double glod;//现有金币
    private Double payGlod;//累计充值金币
    private Double withdrawGlod;//累计提现金币
    private Date createTime;
}
