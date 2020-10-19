package com.example.fhz.a.aspect;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.fhz.a.annotation.Idempotent;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Aspect
@Component
public class IdempotentAspect {
	
	@Autowired
	StringRedisTemplate redisTemplate;

	@Pointcut("@annotation(com.example.fhz.a.annotation.Idempotent)")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint point) {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Annotation anno = signature.getMethod().getAnnotation(Idempotent.class);
		if(anno!=null) {
			HttpServletRequest request = getRequest();
			String token = request.getHeader("token");
			if(token==null) {
				throw new RuntimeException("没有幂等校验token不允许提交");
			}
			String key = "token:"+token;
			Boolean hasKey = redisTemplate.hasKey(key);
			if(!hasKey) {
				throw new RuntimeException("没有幂等校验token不允许提交");
			}
			Boolean hasDel = redisTemplate.delete(key);
			log.debug("是否已经删除{}",hasDel);
		}
	}
	
	private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }
	
	
}
