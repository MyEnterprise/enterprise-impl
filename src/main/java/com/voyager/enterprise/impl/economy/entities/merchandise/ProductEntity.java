package com.voyager.enterprise.impl.economy.entities.merchandise;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.voyager.enterprise.economy.entity.Merchandise;
import com.voyager.enterprise.impl.economy.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.VolumeEntity;
import com.voyager.enterprise.util.Code;

import jakarta.persistence.OneToMany;

@Entity
public class ProductEntity extends MerchandiseEntity{
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
	private VolumeEntity volume;
	@OneToOne
	private BigDecimal weight;

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
	public VolumeEntity getVolume() {
		return volume;
	}
	public void setVolume(VolumeEntity volume) {
		this.volume = volume;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}
