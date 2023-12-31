package com.voyager.enterprise.impl.domain.entities;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.util.Code;

@Entity
public class FusionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@OneToMany(cascade = CascadeType.ALL)
	private List<EnterpriseEntity> mergingEnterprise;
	@OneToOne
	private EnterpriseEntity resultingEnterprise;
	@Column
	private Map<EnterpriseEntity, Double> ownershipPercentages;

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
	public List<EnterpriseEntity> getMergingEnterprise() {
		return mergingEnterprise;
	}
	public void setMergingEnterprise(List<EnterpriseEntity> mergingEnterprise) {
		this.mergingEnterprise = mergingEnterprise;
	}
	public EnterpriseEntity getResultingEnterprise() {
		return resultingEnterprise;
	}
	public void setResultingEnterprise(EnterpriseEntity resultingEnterprise) {
		this.resultingEnterprise = resultingEnterprise;
	}
	public Map<EnterpriseEntity, Double> getOwnershipPercentages() {
		return ownershipPercentages;
	}
	public void setOwnershipPercentages(Map<EnterpriseEntity, Double> ownershipPercentages) {
		this.ownershipPercentages = ownershipPercentages;
	}
	
}
