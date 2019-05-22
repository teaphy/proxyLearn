package com.teaphy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author teaphy
 * @desc
 * @since 20:43
 */
public class CglibTest {

	public static void main(String[] args) {

		// 1. 创建目标对象
		AndroidDeveloper androidDeveloper = new AndroidDeveloper();
		// 2. 创建代理类对象
		DeveloperMethodInterceptor developerMethodInterceptor = new DeveloperMethodInterceptor();
		// 3. 获取动态代理对象
		AndroidDeveloper androidProxy = (AndroidDeveloper) developerMethodInterceptor
			.getInstance(androidDeveloper);
		// 4. 执行代理对象的方法
		androidProxy.code();
	}
}
