package com.voyager.enterprise.impl.entities;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.voyager.enterprise.impl.economy.entities.TransactionEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class AquisitionEntity {

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
	private EnterpriseEntity acquiring;
	@OneToOne
	private EnterpriseEntity acquired;
	@OneToOne
	private TransactionEntity cost;

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
	public EnterpriseEntity getAcquiring() {
		return acquiring;
	}
	public void setAcquiring(EnterpriseEntity acquiring) {
		this.acquiring = acquiring;
	}
	public EnterpriseEntity getAcquired() {
		return acquired;
	}
	public void setAcquired(EnterpriseEntity acquired) {
		this.acquired = acquired;
	}
	public TransactionEntity getCost() {
		return cost;
	}
	public void setCost(TransactionEntity cost) {
		this.cost = cost;
	}

	
}
