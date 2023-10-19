package com.voyager.enterprise.impl.comercial.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.voyager.enterprise.commercial.entity.Purchase;
import com.voyager.enterprise.commercial.entity.enums.BuyerEnum;
import com.voyager.enterprise.impl.entities.PersonEntity;

import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class BuyerEntity extends PersonEntity{
	private BuyerEnum type;
	private List<PurchaseEntity> listPurchase;
}
