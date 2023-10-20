package com.voyager.enterprise.impl.comercial.entities;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.voyager.enterprise.commercial.entity.Purchase;
import com.voyager.enterprise.commercial.entity.enums.BuyerEnum;
import com.voyager.enterprise.impl.entities.PersonEntity;
import com.voyager.enterprise.util.Code;

import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class BuyerEntity extends PersonEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;

	private BuyerEnum type;
	private List<PurchaseEntity> listPurchase;
}
