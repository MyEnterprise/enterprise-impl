package com.voyager.enterprise.impl.economy.entities.merchandise;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.voyager.enterprise.economy.entity.Merchandise;
import com.voyager.enterprise.impl.economy.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.VolumeEntity;

@Entity
public class ProductEntity extends MerchandiseEntity{
	private VolumeEntity volume;
	private BigDecimal weight;
}
