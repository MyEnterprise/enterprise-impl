package com.voyager.enterprise.impl.logistics.entities.storage.inventory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.impl.logistics.entities.distribution.ExpeditionEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.bound.BoundStatusEntity;
import com.voyager.enterprise.logistics.entity.storage.inventory.bound.enums.BoundStatusEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class BoundEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
    
    private ExpeditionEntity expedition;
    private BoundStatusEnum status;
    private List<BoundStatusEntity> listStatus;
    // Obejto com os dados do trasnporte de transporte
    private Code<String> locationInvetory;

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
    public ExpeditionEntity getExpedition() {
        return expedition;
    }
    public void setExpedition(ExpeditionEntity expedition) {
        this.expedition = expedition;
    }
    public BoundStatusEnum getStatus() {
        return status;
    }
    public void setStatus(BoundStatusEnum status) {
        this.status = status;
    }
    public List<BoundStatusEntity> getListStatus() {
        return listStatus;
    }
    public void setListStatus(List<BoundStatusEntity> listStatus) {
        this.listStatus = listStatus;
    }
    public Code<String> getLocationInvetory() {
        return locationInvetory;
    }
    public void setLocationInvetory(Code<String> locationInvetory) {
        this.locationInvetory = locationInvetory;
    }

}
