package com.voyager.enterprise.impl.domain.entities;

import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.util.Code;

@Entity
public class TaxIdentificationEntity {

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
    private TaxEntity tax;
	@Column
    private String identification;

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
	public TaxEntity getTax() {
		return tax;
	}
	public void setTax(TaxEntity tax) {
		this.tax = tax;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
