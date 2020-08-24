package com.example.fhz.a.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.fhz.a.feign.factory.FeignOneFactory;

@FeignClient(value = "fhz-server-b",fallbackFactory = FeignOneFactory.class)
public interface FeignOne {

	@GetMapping("serverb")
	public String serverb();
}
