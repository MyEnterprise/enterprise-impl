package com.voyager.enterprise.impl.economy.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.voyager.enterprise.economy.entity.enums.TransactionStatusEnum;
import com.voyager.enterprise.impl.economy.entities.transaction.TransactionStatusEntity;
import com.voyager.enterprise.impl.economy.entities.transaction.TransferenceEntity;
import com.voyager.enterprise.util.Code;

@MappedSuperclass
public class TransactionEntity{

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
	private List<TransferenceEntity> listTransference;
	@Enumerated(EnumType.STRING)
	private TransactionStatusEnum status;
	@OneToMany
	private List<TransactionStatusEntity> listStatus;
	@Column
	private LocalDate dt;

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
	public List<TransferenceEntity> getListTransference() {
		return listTransference;
	}
	public void setListTransference(List<TransferenceEntity> listTransference) {
		this.listTransference = listTransference;
	}
	public TransactionStatusEnum getStatus() {
		return status;
	}
	public void setStatus(TransactionStatusEnum status) {
		this.status = status;
	}
	public List<TransactionStatusEntity> getListStatus() {
		return listStatus;
	}
	public void setListStatus(List<TransactionStatusEntity> listStatus) {
		this.listStatus = listStatus;
	}
	public LocalDate getDt() {
		return dt;
	}
	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

}
