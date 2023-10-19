package com.voyager.enterprise.impl.logistics.entities.distribution;

import java.util.List;
import java.util.UUID;

import com.voyager.enterprise.impl.logistics.entities.distribution.expedition.ExpeditionStatusEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.ShipmentEntity;
import com.voyager.enterprise.logistics.entity.distribution.expedition.enums.ExpeditionEnum;
import com.voyager.enterprise.util.Code;

public class ExpeditionEntity {
	public UUID id;
    public Code<String> locationInvetory;
    public ShipmentEntity shipment;
    public List<TransportEntity> transport;
    public ExpeditionEnum type;
    public List<ExpeditionStatusEntity> listStatus;
}
