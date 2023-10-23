package com.voyager.enterprise.impl.entities;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.voyager.enterprise.impl.economy.entities.TransactionEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class DivisionEntity{
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
	private EnterpriseEntity originalEnterprise;
	@OneToMany
	private List<EnterpriseEntity> resultingEnterprise;
	@Column
	private Map<EnterpriseEntity, TransactionEntity> transferredAssetsEnterprise;

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
	public EnterpriseEntity getOriginalEnterprise() {
		return originalEnterprise;
	}
	public void setOriginalEnterprise(EnterpriseEntity originalEnterprise) {
		this.originalEnterprise = originalEnterprise;
	}
	public List<EnterpriseEntity> getResultingEnterprise() {
		return resultingEnterprise;
	}
	public void setResultingEnterprise(List<EnterpriseEntity> resultingEnterprise) {
		this.resultingEnterprise = resultingEnterprise;
	}
	public Map<EnterpriseEntity, TransactionEntity> getTransferredAssetsEnterprise() {
		return transferredAssetsEnterprise;
	}
	public void setTransferredAssetsEnterprise(Map<EnterpriseEntity, TransactionEntity> transferredAssetsEnterprise) {
		this.transferredAssetsEnterprise = transferredAssetsEnterprise;
	}

}
