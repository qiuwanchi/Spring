package com.secoo.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	private static String configLocation = "applicationContext.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
	
	public static Object getBean(String beanName){
		Object obj = ctx.getBean(beanName);
		return obj;
	}
}
