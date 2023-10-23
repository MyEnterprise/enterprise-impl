package com.voyager.enterprise.impl.logistics.entities.storage.inventory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.voyager.enterprise.impl.economy.entities.merchandise.ProductEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class ShipmentEntity {
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
    private ProductEntity merchandise;
	@Column
    private LocalDate dtValid;
	@Column
    private BigDecimal ammount;

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
    public ProductEntity getMerchandise() {
        return merchandise;
    }
    public void setMerchandise(ProductEntity merchandise) {
        this.merchandise = merchandise;
    }
    public LocalDate getDtValid() {
        return dtValid;
    }
    public void setDtValid(LocalDate dtValid) {
        this.dtValid = dtValid;
    }
    public BigDecimal getAmmount() {
        return ammount;
    }
    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }
   
}
