package com.teaphy.static_proxy;

import com.teaphy.interfaces.IDevelop;

/**
 * @author teaphy
 * @desc
 * @since 20:41
 */
public class JavaDeveloper implements IDevelop {

	@Override
	public void code() {
		System.out.println("JavaDeveloper is coding!");
	}
}
