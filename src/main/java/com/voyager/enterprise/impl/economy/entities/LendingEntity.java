package com.voyager.enterprise.impl.economy.entities;

import java.util.List;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.economy.entities.lending.FeeEntity;
import com.voyager.enterprise.impl.economy.entities.lending.InterestEntity;

@Entity
public class LendingEntity extends TransactionEntity{
	private List<FeeEntity> listFee;
	private List<InterestEntity> listInterest;
}
