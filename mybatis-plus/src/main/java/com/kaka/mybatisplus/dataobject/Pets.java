package com.kaka.mybatisplus.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 贾双凯
 * @since 2018-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Pets implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer ownerId;


}
