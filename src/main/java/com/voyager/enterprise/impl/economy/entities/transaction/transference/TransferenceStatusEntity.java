package com.voyager.enterprise.impl.economy.entities.transaction.transference;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Entity;

import com.voyager.enterprise.economy.entity.enums.TransactionStatusEnum;

@Entity
public class TransferenceStatusEntity {
	public TransactionStatusEnum status;
    public String desc;
    public LocalDate dt;
    public Map<String,String> attributes;
}
