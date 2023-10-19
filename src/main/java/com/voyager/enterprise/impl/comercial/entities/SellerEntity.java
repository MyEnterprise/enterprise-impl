package com.voyager.enterprise.impl.comercial.entities;

import java.util.List;

import javax.persistence.Entity;

import com.voyager.enterprise.commercial.entity.enums.SellerEnum;
import com.voyager.enterprise.impl.entities.PersonEntity;

@Entity
public class SellerEntity extends PersonEntity{
	private SellerEnum type;
	private List<SaleEntity> sales;
}
