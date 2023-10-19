package com.voyager.enterprise.impl.logistics.entities.storage;

import java.util.List;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.logistics.entities.distribution.AddressEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class WareHouseEntity {
	public Code<String> code;
    public AddressEntity local;
    public List<DepositEntity> listDeposit;
}
