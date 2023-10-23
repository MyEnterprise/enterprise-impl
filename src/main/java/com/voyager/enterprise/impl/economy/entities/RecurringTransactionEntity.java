package com.voyager.enterprise.impl.economy.entities;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.economy.entity.Transaction;
import com.voyager.enterprise.economy.entity.enums.RecurringEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class RecurringTransactionEntity extends TransactionEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@Enumerated(EnumType.STRING)
	private RecurringEnum recurringEnum;

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

	public RecurringEnum getRecurringEnum() {
		return recurringEnum;
	}

	public void setRecurringEnum(RecurringEnum recurringEnum) {
		this.recurringEnum = recurringEnum;
	}

}
