package com.kaka.jtest.mybatis.mapper;

import com.kaka.jtest.mybatis.entities.User;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-09 20:23
 */
public interface LabelMapper {
    void setLabelTest(User user);

    void ifLabelTest(User user);
}
