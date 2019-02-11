package com.kaka.mybatisplus.mapper;

import com.kaka.mybatisplus.dataobject.Pets;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaka.mybatisplus.dataobject.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 贾双凯
 * @since 2018-11-29
 */
public interface PetsMapper extends BaseMapper<Pets> {
    Pets selectOneByName(String name);
}
