package com.kaka.jtest.sharding.service.impl;

import com.kaka.jtest.sharding.dataobject.Person;
import com.kaka.jtest.sharding.mapper.PersonMapper;
import com.kaka.jtest.sharding.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 贾双凯
 * @since 2019-06-04
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
