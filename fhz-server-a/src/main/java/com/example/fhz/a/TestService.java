package com.example.fhz.a;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
@Service
public class TestService {

//	@SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
