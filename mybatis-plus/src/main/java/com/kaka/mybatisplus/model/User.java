package com.kaka.mybatisplus.model;

import lombok.Data;

/**
 * @author jsk
 * @Date 2018/9/26 16:45
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
