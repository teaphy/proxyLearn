package com.teaphy.static_proxy;

import com.teaphy.interfaces.IDevelop;

/**
 * @author teaphy
 * @desc
 * @since 20:42
 */
public class DevelopProxy implements IDevelop {

	IDevelop deveop;

	public DevelopProxy(IDevelop deveop) {
		this.deveop = deveop;
	}

	@Override
	public void code() {
		System.out.println("coding 之前，更新代码");
		deveop.code();
		System.out.println("coding 之后，提交代码");
	}
}
