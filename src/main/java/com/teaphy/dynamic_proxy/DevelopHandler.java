package com.teaphy.dynamic_proxy;

import com.teaphy.interfaces.IDevelop;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DevelopHandler implements InvocationHandler {

	// 目标对象
	private IDevelop develop;

	public DevelopHandler(IDevelop develop) {
		this.develop = develop;
	}

	/**
	 * @param proxy: 代表动态代理对象
	 * @param method：代表正在执行的方法
	 * @param args：代表调用目标方法时传入的实参
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


		System.out.println("coding 之前，更新代码");

		Object invoke = method.invoke(develop, args);

		System.out.println("coding 之后，提交代码");

		return invoke;
	}
}
