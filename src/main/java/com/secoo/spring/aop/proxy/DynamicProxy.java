package com.secoo.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	// 要代理的对象
	private Object target;

	// 将构造方法禁用掉，不让外部通过new来得到DynamicProxy对象
	private DynamicProxy() {

	}

	/**
	 * 返回一个动态的代理对象
	 * 
	 * @param object被代理对象
	 * @return<br/>
	 * @author qiuwanchi<br/>
	 * @date: 2016年6月23日 <br/>
	 */
	public static Object newInstance(Object object) {
		DynamicProxy proxy = new DynamicProxy();
		proxy.target = object;
		
		//通过Proxy的newProxyInstance方法来得到一个代理对象
		Object result = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),proxy);
		return result;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// // 只有方法名为add和delete时候才引入日志
		// if(method.getName().equals("add") ||
		// method.getName().equals("delete"))
		// {
		// Logger.logInfo("动态代理类");
		// }

		// 根据LogAnnotation来判断，如果被标注了注解，则输出日志
		/*
		 * if (method.isAnnotationPresent(LogAnnotation.class)) { LogAnnotation
		 * log = method.getAnnotation(LogAnnotation.class);
		 * Logger.logInfo(log.value()); }
		 */

		System.out.println("调用之前。。。。。。。。。。。。。");
		Object object = method.invoke(target, args);
		
		System.out.println("调用之后。。。。。。。。。。。。。");
		return object;
	}
}