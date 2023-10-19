package com.voyager.enterprise.impl.logistics.entities.storage.inventory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.voyager.enterprise.impl.economy.entities.merchandise.ProductEntity;
import com.voyager.enterprise.util.Code;

public class ShipmentEntity {
	public UUID id;
    public Code<String> code;
    public ProductEntity merchandise;
    public LocalDate dtValid;
    public BigDecimal ammount;
}
