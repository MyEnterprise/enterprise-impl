package com.voyager.enterprise.impl.comercial.entities;

import java.math.BigDecimal;
import java.util.List;

import com.voyager.enterprise.impl.economy.entities.TransactionEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.WareHouseEntity;

public class OrderEntity {
	private OfferEntity offer;
    private BigDecimal amount;
    private WareHouseEntity deposit;
    private List<TransactionEntity> transaction;
}
