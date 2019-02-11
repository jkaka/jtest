package com.kaka.mybatisplus.controller;


import com.kaka.mybatisplus.dataobject.Pets;
import com.kaka.mybatisplus.mapper.PetsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 贾双凯
 * @since 2018-11-29
 */
@RestController
@RequestMapping("/petController")
public class PetsController {

    @Autowired
    private PetsMapper petsMapper;

    @GetMapping("/pet/name/{name}")
    public Pets selectOneByName(@PathVariable String name) {
        return petsMapper.selectOneByName(name);
    }

}
