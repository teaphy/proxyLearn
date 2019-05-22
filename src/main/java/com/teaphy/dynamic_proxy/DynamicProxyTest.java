package com.teaphy.dynamic_proxy;

import com.teaphy.interfaces.IDevelop;
import com.teaphy.static_proxy.DevelopProxy;
import com.teaphy.static_proxy.HtmlDeveloper;
import com.teaphy.static_proxy.JavaDeveloper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author teaphy
 * @desc
 * @since 20:43
 */
public class DynamicProxyTest {

	public static void main(String[] args) {

		// 1. 创建目目标对象
		IDevelop javaDev = new JavaDeveloper();
		IDevelop htmlDev = new HtmlDeveloper();

		// 2. 创建一个与代理对象相关联的InvocationHandler实现类的实例
		InvocationHandler javaHandler = new DevelopHandler(javaDev);
		InvocationHandler htmlHandler = new DevelopHandler(htmlDev);

		// 3. 创建动态代理
		// 3.1 newProxyInstance()会返回一个实现了指定接口的代理对象，
		//     对该对象的所有方法调用都会转发给InvocationHandler.invoke()方法。
		IDevelop javaProxy = (IDevelop) Proxy.newProxyInstance(javaDev.getClass().getClassLoader(),
			new Class[]{IDevelop.class},
			javaHandler);

		IDevelop htmlProxy = (IDevelop) Proxy.newProxyInstance(htmlDev.getClass().getClassLoader(),
			new Class[]{IDevelop.class},
			htmlHandler);

		// 4. 方法执行
		javaProxy.code();

		System.out.println("*******************");

		htmlProxy.code();

	}
}
