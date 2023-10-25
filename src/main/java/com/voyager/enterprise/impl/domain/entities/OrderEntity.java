package com.voyager.enterprise.impl.domain.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.impl.domain.entities.storage.WareHouseEntity;
import com.voyager.enterprise.util.Code;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
	@OneToOne
	private OfferEntity offer;
	@Column
    private BigDecimal amount;
    @OneToOne
    private WareHouseEntity deposit;
    @OneToMany(cascade = CascadeType.ALL)
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
