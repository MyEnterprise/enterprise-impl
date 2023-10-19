package com.voyager.enterprise.impl.entities;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.economy.entities.TransactionEntity;

@Entity
public class DivisionEntity{
	private EnterpriseEntity originalEnterprise;
	private List<EnterpriseEntity> resultingEnterprise;
	private Map<EnterpriseEntity, TransactionEntity> transferredAssetsEnterprise;
}
