package com.voyager.enterprise.impl.domain.entities.storage;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.impl.domain.entities.storage.inventory.InBoundEntity;
import com.voyager.enterprise.impl.domain.entities.storage.inventory.OutBoundEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class InventoryEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
    
    // formato de organização
    // Aberto
    // Prateleiras
    // Pilhas
	@OneToMany(cascade = CascadeType.ALL)
    private List<InBoundEntity> listInBound;
	@OneToMany(cascade = CascadeType.ALL)
    private List<OutBoundEntity> listOutBound;

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
    public List<InBoundEntity> getListInBound() {
        return listInBound;
    }
    public void setListInBound(List<InBoundEntity> listInBound) {
        this.listInBound = listInBound;
    }
    public List<OutBoundEntity> getListOutBound() {
        return listOutBound;
    }
    public void setListOutBound(List<OutBoundEntity> listOutBound) {
        this.listOutBound = listOutBound;
    }
}
