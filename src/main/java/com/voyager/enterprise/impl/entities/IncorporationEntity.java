package com.voyager.enterprise.impl.entities;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.economy.entities.TransactionEntity;

@Entity
public class IncorporationEntity {
	private EnterpriseEntity acquiring;
	private EnterpriseEntity acquired;
	private TransactionEntity cost;
}
