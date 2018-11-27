package com.kaka.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author jsk
 * @Date 2018/11/8 9:37
 */
@Data
@TableName("users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @TableField(fill = FieldFill.INSERT)
    private String email;
    @TableField(value = "address")
    private String address1;
    @TableLogic
    private String status;
    private String userAccount;
    @Version
    private Integer version;
    @TableField(exist = false)
    private String noUse;
}
