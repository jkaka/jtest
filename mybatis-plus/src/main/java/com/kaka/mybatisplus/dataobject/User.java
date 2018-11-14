package com.kaka.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author jsk
 * @Date 2018/11/8 9:37
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private String status;
}
