package com.example.fhz.b.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("serverb")
	public String serverb() {
		return "server-b";
	}

}
