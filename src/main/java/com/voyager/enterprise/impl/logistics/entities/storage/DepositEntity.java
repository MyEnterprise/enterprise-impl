package com.voyager.enterprise.impl.logistics.entities.storage;

import java.util.List;

import com.voyager.enterprise.logistics.entity.storage.enums.DepositEnum;
import com.voyager.enterprise.util.Code;

public class DepositEntity {
	public Code<String> code;
    public InventoryEntity inventory;
    public List<DepositEnum> type;
}
