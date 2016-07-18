package com.secoo.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private Object subject;//被代理的对象
	
	public DynamicProxy(Object subject){
		this.subject = subject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//proxy 是生成的代理对象
		//subject 是被代理对象
		//method 执行的方法
		
		System.out.println("被代理对象执行之前。。。。。。。。。。。。");
		System.out.println(proxy.getClass().getName());
		System.out.println("method :" + method);
		
		method.invoke(subject, args);
		
		System.out.println("被代理对象执行之后。。。。。。。。。。。。");
		return null;
	}

	public static void main(String[] args) {
		Subject subject = new RealSubject();
		InvocationHandler a = new DynamicProxy(subject);
		System.out.println(a.getClass().getClassLoader() == subject.getClass().getClassLoader());

		Subject obj = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), a);

		System.out.println(obj.getClass().getName());
		obj.rent();
	}

}
