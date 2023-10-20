package com.voyager.enterprise.impl.operation.entities;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.operation.entity.jobs.enums.JobRecurringEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class JobRecurringEntity extends JobEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	
	private JobRecurringEnum type;

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

	public JobRecurringEnum getType() {
		return type;
	}

	public void setType(JobRecurringEnum type) {
		this.type = type;
	}

}
