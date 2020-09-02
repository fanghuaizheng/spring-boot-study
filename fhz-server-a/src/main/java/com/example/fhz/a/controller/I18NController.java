package com.example.fhz.a.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 国际化测试类
 * @author JVC20190082
 *
 */
@RestController
@RequestMapping("i18n")
public class I18NController {

	@Autowired
	MessageSource messgeSource;
	
	@RequestMapping("getValue")
	public Object getValue() {
		Locale local = LocaleContextHolder.getLocale();
		return messgeSource.getMessage("welcome", null,local);
	}
	
}
