package com.voyager.enterprise.impl.entities;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.voyager.enterprise.impl.entities.person.ContactEntity;
import com.voyager.enterprise.impl.logistics.entities.distribution.AddressEntity;
import com.voyager.enterprise.impl.plugin.tax.entities.TaxIdentificationEntity;
import com.voyager.enterprise.util.Code;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@MappedSuperclass
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;

	private String name;
	private TaxIdentificationEntity identification;
	private List<AddressEntity> listAddress;
	private List<ContactEntity> listContact;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TaxIdentificationEntity getIdentification() {
		return identification;
	}
	public void setIdentification(TaxIdentificationEntity identification) {
		this.identification = identification;
	}
	public List<AddressEntity> getListAddress() {
		return listAddress;
	}
	public void setListAddress(List<AddressEntity> listAddress) {
		this.listAddress = listAddress;
	}
	public List<ContactEntity> getListContact() {
		return listContact;
	}
	public void setListContact(List<ContactEntity> listContact) {
		this.listContact = listContact;
	}

}
