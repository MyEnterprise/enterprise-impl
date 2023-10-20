package com.voyager.enterprise.impl.comercial.entities;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.voyager.enterprise.commercial.entity.Purchase;
import com.voyager.enterprise.commercial.entity.enums.BuyerEnum;
import com.voyager.enterprise.impl.entities.PersonEntity;
import com.voyager.enterprise.util.Code;

import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class BuyerEntity extends PersonEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;

	private BuyerEnum type;
	
	@OneToMany
	private List<PurchaseEntity> listPurchase;

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
	public BuyerEnum getType() {
		return type;
	}
	public void setType(BuyerEnum type) {
		this.type = type;
	}
	public List<PurchaseEntity> getListPurchase() {
		return listPurchase;
	}
	public void setListPurchase(List<PurchaseEntity> listPurchase) {
		this.listPurchase = listPurchase;
	}

}
