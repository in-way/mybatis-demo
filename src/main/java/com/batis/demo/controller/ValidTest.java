package com.batis.demo.controller;

import com.batis.demo.annoation.GbpsRest;
import com.batis.demo.entity.ValidEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ivy
 * @date 2021年09月07日 15:44
 */
@GbpsRest
@RestController
@RequestMapping("valid")
public class ValidTest {

    @GetMapping("test")
    public String testValid(@Valid ValidEntity validEntity){
        return null;
    }
}
