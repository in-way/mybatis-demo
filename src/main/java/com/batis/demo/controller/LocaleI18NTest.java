package com.batis.demo.controller;

import com.batis.demo.annoation.GbpsRest;
import com.batis.demo.util.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ivy
 * @date 2021年09月09日 16:40
 */
@RestController
@RequestMapping("18n")
@GbpsRest
public class LocaleI18NTest {
    @GetMapping("test")
    public String testValid(){
        return MessageSource.get("user.login");
    }
}
