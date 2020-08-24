package com.example.fhz.b.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("serverb")
	public String serverb() {
//		if(true) {
//			throw new RuntimeException("发生错误");
//		}
		
//		try {
//			Thread.sleep(500000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "server-b";
	}

}
