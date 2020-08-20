package com.example.fhz.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhz.a.feign.FeignOne;
import com.example.fhz.a.service.TestService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class TestController {
	
	@Autowired
	FeignOne feignOne;

	@Autowired
    private TestService service;

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }
    
    @GetMapping("get")
    public Object aouGet() {
    	log.info("你好");
    	return "get";
    }
    
    @GetMapping("feign")
    public Object feign() {
    	return feignOne.serverb();
    }
}
