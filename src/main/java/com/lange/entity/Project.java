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
@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int type; //'1：台球   2：篮球'
    private String img;
    private Date createTimel;
}
