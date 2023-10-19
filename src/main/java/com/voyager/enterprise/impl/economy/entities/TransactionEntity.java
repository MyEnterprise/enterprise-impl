package com.voyager.enterprise.impl.economy.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;

import com.voyager.enterprise.economy.entity.enums.TransactionStatusEnum;
import com.voyager.enterprise.economy.entity.transaction.TransactionStatus;
import com.voyager.enterprise.impl.economy.entities.transaction.TransactionStatusEntity;
import com.voyager.enterprise.impl.economy.entities.transaction.TransferenceEntity;


@Entity
public class TransactionEntity{
	private UUID id;
	private List<TransferenceEntity> listTransference;
	private TransactionStatusEnum status;
	private List<TransactionStatusEntity> listStatus;
	private String desc;
	private Map<String, String> attributes;
	private LocalDate dt;
}
