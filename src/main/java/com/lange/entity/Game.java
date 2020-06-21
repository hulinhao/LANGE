package com.lange.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
/**
 *
 * @Author linhao Hu
 * @Date
 *
 */
@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerOne;
    private String playerTwo;
    private Long proId;
    private Double odds;    //赔率   playerOne  1 : odds playerTwo
    private int type;       //状态  0:有效  1:失效
    private Date createTime;
    private Date endTime;
}
