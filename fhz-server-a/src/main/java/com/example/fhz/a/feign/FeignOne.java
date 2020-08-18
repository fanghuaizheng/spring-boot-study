package com.example.fhz.a.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "fhz-server-b")
public interface FeignOne {

	@GetMapping("serverb")
	public String serverb();
}
