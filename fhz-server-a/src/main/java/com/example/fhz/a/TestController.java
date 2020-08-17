package com.example.fhz.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.fhz.a.feign.FeignOne;
@RestController
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
    	return "get";
    }
    
    @GetMapping("feign")
    public Object feign() {
    	return feignOne.serverb();
    }
}
