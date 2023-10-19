package com.voyager.enterprise.impl.economy.entities.lending;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.economy.entities.merchandise.CoinEntity;

@Entity
public class FeeEntity {
	private String desc;
	private CoinEntity coin;
	private BigDecimal amount;
}
