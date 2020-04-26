package com.example.fhz.springboot.encryptconfig.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author woni
 * @Description:
 * @date 2020-04-26 11:38
 */
@RestController
public class TestController {

    @Autowired
    StringEncryptor encryptor;

//    @Autowired
//    StringD

    @Value("${test.one}")
    public String one;



    @RequestMapping("getEncode/{value}")
    public Object getEncode(@PathVariable("value") String value){
        return encryptor.encrypt(value);
    }

    @RequestMapping("getDecode")
    public Object getDecode( String value){
        return one;
    }

}
