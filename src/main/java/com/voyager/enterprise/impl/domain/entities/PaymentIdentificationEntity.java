package com.voyager.enterprise.impl.domain.entities;

import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.util.Code;

@Entity
public class PaymentIdentificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@Column
    private String identification;
	@OneToOne
    private PaymentEntity payment;

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
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public PaymentEntity getPayment() {
		return payment;
	}
	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

}
