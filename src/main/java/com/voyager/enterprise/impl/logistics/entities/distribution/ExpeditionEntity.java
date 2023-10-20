package com.voyager.enterprise.impl.logistics.entities.distribution;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.impl.logistics.entities.distribution.expedition.ExpeditionStatusEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.ShipmentEntity;
import com.voyager.enterprise.logistics.entity.distribution.expedition.enums.ExpeditionEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class ExpeditionEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;

    private Code<String> locationInvetory;
    private ShipmentEntity shipment;
    private List<TransportEntity> transport;
    private ExpeditionEnum type;
    private List<ExpeditionStatusEntity> listStatus;

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
    public Code<String> getLocationInvetory() {
        return locationInvetory;
    }
    public void setLocationInvetory(Code<String> locationInvetory) {
        this.locationInvetory = locationInvetory;
    }
    public ShipmentEntity getShipment() {
        return shipment;
    }
    public void setShipment(ShipmentEntity shipment) {
        this.shipment = shipment;
    }
    public List<TransportEntity> getTransport() {
        return transport;
    }
    public void setTransport(List<TransportEntity> transport) {
        this.transport = transport;
    }
    public ExpeditionEnum getType() {
        return type;
    }
    public void setType(ExpeditionEnum type) {
        this.type = type;
    }
    public List<ExpeditionStatusEntity> getListStatus() {
        return listStatus;
    }
    public void setListStatus(List<ExpeditionStatusEntity> listStatus) {
        this.listStatus = listStatus;
    }
}
