package com.voyager.enterprise.impl.economy.entities.lending;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.economy.entities.merchandise.CoinEntity;

@Entity
public class InterestEntity {
	public String desc;
    public CoinEntity coin;
    public BigDecimal amount;
}
