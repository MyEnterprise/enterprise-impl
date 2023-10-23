package com.voyager.enterprise.impl.economy.entities;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.impl.economy.entities.lending.FeeEntity;
import com.voyager.enterprise.impl.economy.entities.lending.InterestEntity;
import com.voyager.enterprise.util.Code;

import jakarta.persistence.OneToMany;

@Entity
public class LendingTransactionEntity extends TransactionEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@OneToMany
	private List<FeeEntity> listFee;
	@OneToMany
	private List<InterestEntity> listInterest;

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
	public List<FeeEntity> getListFee() {
		return listFee;
	}
	public void setListFee(List<FeeEntity> listFee) {
		this.listFee = listFee;
	}
	public List<InterestEntity> getListInterest() {
		return listInterest;
	}
	public void setListInterest(List<InterestEntity> listInterest) {
		this.listInterest = listInterest;
	}

}
