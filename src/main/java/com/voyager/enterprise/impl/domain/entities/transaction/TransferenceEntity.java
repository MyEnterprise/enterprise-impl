package com.voyager.enterprise.impl.domain.entities.transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.economy.entity.transaction.transference.enums.TransferenceStatusEnum;
import com.voyager.enterprise.impl.domain.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.domain.entities.transaction.transference.TransferenceStatusEntity;
import com.voyager.enterprise.impl.domain.entities.PersonEntity;
import com.voyager.enterprise.util.Code;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TransferenceEntity {
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
	private MerchandiseEntity merchandise;
	@Column
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	private TransferenceStatusEnum status;
	@OneToMany(cascade = CascadeType.ALL)
    private List<TransferenceStatusEntity> listStatus;
	@OneToOne
    private PersonEntity sender;
	@OneToOne
    private PersonEntity receiver;

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
	public MerchandiseEntity getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(MerchandiseEntity merchandise) {
		this.merchandise = merchandise;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public TransferenceStatusEnum getStatus() {
		return status;
	}
	public void setStatus(TransferenceStatusEnum status) {
		this.status = status;
	}
	public List<TransferenceStatusEntity> getListStatus() {
		return listStatus;
	}
	public void setListStatus(List<TransferenceStatusEntity> listStatus) {
		this.listStatus = listStatus;
	}
	public PersonEntity getSender() {
		return sender;
	}
	public void setSender(PersonEntity sender) {
		this.sender = sender;
	}
	public PersonEntity getReceiver() {
		return receiver;
	}
	public void setReceiver(PersonEntity receiver) {
		this.receiver = receiver;
	}

}
