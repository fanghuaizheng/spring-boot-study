package com.example.fhz.a.feign.factory;

import org.springframework.stereotype.Component;

import com.example.fhz.a.feign.FeignOne;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class FeignOneFactory implements FallbackFactory<FeignOne>{

	@Override
	public FeignOne create(Throwable cause) {
		log.error("feign one 接口发生错误{}",cause.getMessage());
		return new FeignOne() {
			
			@Override
			public String serverb() {
				
				return "这是错误容错处理";
			}
		};
	}

}
