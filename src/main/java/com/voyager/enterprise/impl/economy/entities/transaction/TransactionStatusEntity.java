package com.voyager.enterprise.impl.economy.entities.transaction;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Entity;

import com.voyager.enterprise.economy.entity.enums.TransactionStatusEnum;

@Entity
public class TransactionStatusEntity {
	private TransactionStatusEnum status;
	private String desc;
    private LocalDate dt;
    private Map<String,String> attributes;
}
