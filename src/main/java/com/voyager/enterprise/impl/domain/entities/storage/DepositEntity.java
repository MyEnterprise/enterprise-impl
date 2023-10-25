package com.voyager.enterprise.impl.domain.entities.storage;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.logistics.entity.storage.enums.DepositEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class DepositEntity {
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
    private InventoryEntity inventory;
    @Column
    private List<DepositEnum> type;

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
    public InventoryEntity getInventory() {
        return inventory;
    }
    public void setInventory(InventoryEntity inventory) {
        this.inventory = inventory;
    }
    public List<DepositEnum> getType() {
        return type;
    }
    public void setType(List<DepositEnum> type) {
        this.type = type;
    }

    
}
