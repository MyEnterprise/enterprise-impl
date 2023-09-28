package com.voyager.enterprise.impl;

import java.time.Duration;
import java.util.Properties;
import java.util.function.Consumer;

import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.economy.ManagerEconomy;
import com.voyager.enterprise.manager.financial.ManagerFinancial;
import com.voyager.enterprise.manager.logistics.ManagerLogistics;
import com.voyager.enterprise.manager.people.ManagerPeople;
import com.voyager.enterprise.manager.project.ManagerProject;
import com.voyager.enterprise.server.Server;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;


public class ServerManager implements Server {

	public static CircuitBreaker circuitBreaker;

	public ServerManager() {
		circuitBreaker = CircuitBreaker.of("ServerManager", CircuitBreakerConfig.custom()
	            .failureRateThreshold(50) // Taxa de falha de 50%
	            .waitDurationInOpenState(Duration.ofSeconds(5)) // Tempo de espera no estado aberto
	            .build());
		
		circuitBreaker.decorateConsumer(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("ServerManager:");
				System.out.println(t);
			}
		});
	}

	@Override
	public ManagerCommercial getManagerCommercial() {
		return null;
	}

	@Override
	public ManagerEconomy getManagerEconomy() {
		return null;
	}

	@Override
	public ManagerFinancial getManagerFinancial() {
		return null;
	}

	@Override
	public ManagerLogistics getManagerLogistics() {
		return null;
	}

	@Override
	public ManagerPeople getManagerPeople() {
		return null;
	}

	@Override
	public ManagerProject getManagerProject() {
		return null;
	}

	@Override
	public Properties getConfig() {
		return null;
	}
}
