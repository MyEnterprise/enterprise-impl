package com.voyager.enterprise.impl.domain.entities.distribution.transport;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.logistics.entity.distribution.transport.enums.TransportStatusEnum;
import com.voyager.enterprise.util.Code;

@Entity
public class TransportStatusEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@Enumerated(EnumType.STRING)
    private TransportStatusEnum status;
	@Column
    private LocalDate dt;
    
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
    public TransportStatusEnum getStatus() {
        return status;
    }
    public void setStatus(TransportStatusEnum status) {
        this.status = status;
    }
    public LocalDate getDt() {
        return dt;
    }
    public void setDt(LocalDate dt) {
        this.dt = dt;
    }

    

}
