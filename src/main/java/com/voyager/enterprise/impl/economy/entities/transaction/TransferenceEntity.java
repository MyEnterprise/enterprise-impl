package com.voyager.enterprise.impl.economy.entities.transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;

import com.voyager.enterprise.economy.entity.transaction.transference.enums.TransferenceStatusEnum;
import com.voyager.enterprise.impl.economy.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.economy.entities.transaction.transference.TransferenceStatusEntity;
import com.voyager.enterprise.impl.entities.PersonEntity;

@Entity
public class TransferenceEntity {
	private UUID id;
	private String desc;
	private MerchandiseEntity merchandise;
	private BigDecimal amount;
	private TransferenceStatusEnum status;
    private List<TransferenceStatusEntity> listStatus;
    private PersonEntity sender;
    private PersonEntity receiver;
}
