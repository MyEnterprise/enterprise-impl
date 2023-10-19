package com.voyager.enterprise.impl.logistics.entities.storage.inventory;

import java.util.List;
import java.util.UUID;

import com.voyager.enterprise.impl.logistics.entities.distribution.ExpeditionEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.bound.BoundStatusEntity;
import com.voyager.enterprise.logistics.entity.storage.inventory.bound.enums.BoundStatusEnum;
import com.voyager.enterprise.util.Code;

public class BoundEntity {
	public UUID id;
    public ExpeditionEntity expedition;
    public BoundStatusEnum status;
    public List<BoundStatusEntity> listStatus;
    // Obejto com os dados do trasnporte de transporte
    public Code<String> locationInvetory;
}
