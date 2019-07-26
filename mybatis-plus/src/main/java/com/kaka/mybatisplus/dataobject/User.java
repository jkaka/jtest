package com.kaka.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author jsk
 * @Date 2018/11/8 9:37
 */
@Data
@TableName("")
public class User {
    /**
     * 如果指定自增id的策略,则传入的id就无效了
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private String status;
    private String userAccount;
    @Version
    private Integer version;
    @TableField(exist = false)
    private String noUse;

}
