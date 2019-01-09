package com.kaka.jtest.mybatis.entities;

import lombok.Data;

import java.util.Date;

/**
 * @author jsk
 * @Date 2018/12/10 14:25
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Long gmtCreate;
}
