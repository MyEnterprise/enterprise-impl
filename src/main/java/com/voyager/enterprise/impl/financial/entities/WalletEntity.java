package com.voyager.enterprise.impl.financial.entities;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voyager.enterprise.financial.entity.enums.WalletEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class WalletEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;

	private WalletEnum type;
    private boolean hasEncrypted;
    private String algorithmEncrypted;
    private String region;
    private String local;

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
    public WalletEnum getType() {
        return type;
    }
    public void setType(WalletEnum type) {
        this.type = type;
    }
    public boolean isHasEncrypted() {
        return hasEncrypted;
    }
    public void setHasEncrypted(boolean hasEncrypted) {
        this.hasEncrypted = hasEncrypted;
    }
    public String getAlgorithmEncrypted() {
        return algorithmEncrypted;
    }
    public void setAlgorithmEncrypted(String algorithmEncrypted) {
        this.algorithmEncrypted = algorithmEncrypted;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

}
