package com.voyager.enterprise.impl.domain.entities.merchandise;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.impl.domain.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.domain.entities.storage.inventory.VolumeEntity;
import com.voyager.enterprise.util.Code;

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
	@Column
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
