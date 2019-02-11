package com.kaka.mybatisplus.service.impl;

import com.kaka.mybatisplus.dataobject.Pets;
import com.kaka.mybatisplus.mapper.PetsMapper;
import com.kaka.mybatisplus.service.PetsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 贾双凯
 * @since 2018-11-29
 */
@Service
public class PetsServiceImpl extends ServiceImpl<PetsMapper, Pets> implements PetsService {


    public void tes(){
//        baseMapper
    }
}
