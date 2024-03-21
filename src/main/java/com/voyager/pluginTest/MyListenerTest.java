package com.voyager.pluginTest;

import com.voyager.enterprise.event.UpdateEnterprise;
import com.voyager.enterprise.financial.entity.Budget;
import com.voyager.enterprise.financial.event.UpdateBudget;

public class MyListenerTest {
	@UpdateEnterprise
	public void teste01() {
		System.out.println("@ExampleEventInMethod.teste01");
	}
	@UpdateBudget
	public void regerargrafico(Budget bug){

	}

}
