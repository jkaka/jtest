package com.kaka.jtest.sharding.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaka.jtest.sharding.dataobject.Person;
import com.kaka.jtest.sharding.service.PersonService;
import io.shardingsphere.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 贾双凯
 * @since 2019-06-04
 */
@RestController
@RequestMapping("/personController")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * insert语句中如果没有分片字段,就回把该条数据保存在所有表中
     *
     * @param person
     * @return
     */
    @ResponseBody
    @PostMapping("/savePerson")
    public String savePerson(@RequestBody Person person) {
        personService.save(person);
        return "savePerson";
    }

    /**
     * 保存
     *
     * @param person
     * @return
     */
    @ResponseBody
    @PostMapping("/saveBatchPerson")
    public String saveBatchPerson(@RequestBody Person person) {
        Person aa = new Person();
        aa.setScore(78);
        personService.saveBatch(Arrays.asList(person, aa));
        return "saveBatchPerson";
    }

    @ResponseBody
    @PostMapping("/selectPerson")
    public List<Person> selectPerson(@RequestBody Person person) {
        Wrapper<Person> personQueryWrapper = new QueryWrapper<>(person);
        return personService.list(personQueryWrapper);
    }

    /**
     * 强制路由,需要配合HintShardingStrategy使用
     *
     * @param person
     * @return
     */
    @ResponseBody
    @PostMapping("/selectPerson/hint")
    public List<Person> selectPersonHint(@RequestBody Person person) {
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("person", 2);

        Wrapper<Person> personQueryWrapper = new QueryWrapper<>(person);
        List<Person> list = personService.list(personQueryWrapper);

        hintManager.close();
        return list;
    }
}
