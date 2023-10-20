package com.voyager.enterprise.impl.comercial.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.impl.economy.entities.TransactionEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.WareHouseEntity;
import com.voyager.enterprise.util.Code;

import jakarta.persistence.Column;

@Entity
public class OrderEntity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;

	private OfferEntity offer;
    private BigDecimal amount;
    private WareHouseEntity deposit;
    private List<TransactionEntity> transaction;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Code<String> getCode() {
        return code;
    }
    public void setCode(Code<String> code) {
        this.code = code;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public OfferEntity getOffer() {
        return offer;
    }
    public void setOffer(OfferEntity offer) {
        this.offer = offer;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public WareHouseEntity getDeposit() {
        return deposit;
    }
    public void setDeposit(WareHouseEntity deposit) {
        this.deposit = deposit;
    }
    public List<TransactionEntity> getTransaction() {
        return transaction;
    }
    public void setTransaction(List<TransactionEntity> transaction) {
        this.transaction = transaction;
    }

}
