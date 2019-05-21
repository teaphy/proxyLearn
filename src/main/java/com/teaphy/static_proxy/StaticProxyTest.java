package com.teaphy.static_proxy;

import com.teaphy.interfaces.IDevelop;

/**
 * @author teaphy
 * @desc
 * @since 20:43
 */
public class StaticProxyTest {

	public static void main(String[] args) {
		IDevelop javaDev = new JavaDeveloper();
		IDevelop htmlDev = new HtmlDeveloper();

		DevelopProxy javaProxy = new DevelopProxy(javaDev);
		DevelopProxy htmlProxy = new DevelopProxy(htmlDev);

		javaProxy.code();

		System.out.println("*************");

		htmlProxy.code();
	}
}
