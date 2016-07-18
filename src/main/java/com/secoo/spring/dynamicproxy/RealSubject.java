package com.secoo.spring.dynamicproxy;

public class RealSubject implements Subject {
	public void doSomething() {
		System.out.println("call doSomething()");
	}
}
