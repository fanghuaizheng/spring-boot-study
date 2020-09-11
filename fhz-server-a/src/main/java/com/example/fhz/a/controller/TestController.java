package com.example.fhz.a.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhz.a.annotation.Idempotent;
import com.example.fhz.a.feign.FeignOne;
import com.example.fhz.a.service.TestService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class TestController {
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	private final String token_pref="token:";
	
	@Autowired
	FeignOne feignOne;

	@Autowired
    private TestService service;
	
	@GetMapping("getToken")
	public String getToken() {
		String token = UUID.randomUUID().toString().replace("-", "");
		String key = token_pref+token;
		redisTemplate.opsForValue().set(key, "1");
		
		redisTemplate.expire(key, 30, TimeUnit.MINUTES);
		return token;
	}

	@GetMapping("checkToken")
	public Object gcheckToken(String token ) {
		String key = token_pref+token;
		return redisTemplate.opsForValue().get(key);
		
	}
	
	@Idempotent
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
