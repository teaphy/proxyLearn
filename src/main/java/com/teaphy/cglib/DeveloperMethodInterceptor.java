package com.teaphy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * MethodInterceptor接口的实现类
 * 方法调用会被转发到该类的intercept()方法。
 */
public class DeveloperMethodInterceptor implements MethodInterceptor {

	// 业务类对象，供代理方法中进行真正的业务方法调用
	Object target;

	public Object getInstance(Object target) {
		//给业务对象赋值
		this.target = target;
		//创建加强器，用来创建动态代理类
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
		//设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
		enhancer.setCallback(this);
		// 创建动态代理类对象并返回
		return enhancer.create();
	}


	/**
	 *
	 * @param object 目标对象
	 * @param method 调用的方法
	 * @param args  传入就去的参数
	 * @param methodProxy 方法代理对象
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
		throws Throwable {

		System.out.println("coding 之前，更新代码");
		Object result = methodProxy.invokeSuper(object, args);
		System.out.println("coding 之后，提交代码");

		return result;
	}
}
