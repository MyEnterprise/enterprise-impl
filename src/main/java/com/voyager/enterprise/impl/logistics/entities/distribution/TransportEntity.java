package com.voyager.enterprise.impl.logistics.entities.distribution;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.impl.logistics.entities.distribution.transport.TransportStatusEntity;
import com.voyager.enterprise.logistics.entity.distribution.transport.enums.TransportEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class TransportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
    
    private String carrier;
    private TransportEnum type;
    private List<TransportStatusEntity> listStatus;
    private AddressEntity originAdress;
    private AddressEntity destinyAddress;

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
    public String getCarrier() {
        return carrier;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public TransportEnum getType() {
        return type;
    }
    public void setType(TransportEnum type) {
        this.type = type;
    }
    public List<TransportStatusEntity> getListStatus() {
        return listStatus;
    }
    public void setListStatus(List<TransportStatusEntity> listStatus) {
        this.listStatus = listStatus;
    }
    public AddressEntity getOriginAdress() {
        return originAdress;
    }
    public void setOriginAdress(AddressEntity originAdress) {
        this.originAdress = originAdress;
    }
    public AddressEntity getDestinyAddress() {
        return destinyAddress;
    }
    public void setDestinyAddress(AddressEntity destinyAddress) {
        this.destinyAddress = destinyAddress;
    }

}
