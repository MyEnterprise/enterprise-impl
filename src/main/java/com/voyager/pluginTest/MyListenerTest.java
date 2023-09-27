package com.voyager.pluginTest;

import com.voyager.enterprise.event.UpdateEnterprise;

public class MyListenerTest {
	@UpdateEnterprise
	public void teste01() {
		System.out.println("@ExampleEventInMethod.teste01");
	}
}
