package com.kaka.jtest.sharding.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 注意生成的代码可能不带id(主键)
 *
 * @author 贾双凯
 * @since 2019-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private Integer score;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

}
