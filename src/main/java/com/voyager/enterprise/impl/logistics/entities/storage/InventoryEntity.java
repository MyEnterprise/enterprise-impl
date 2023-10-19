package com.voyager.enterprise.impl.logistics.entities.storage;

import java.util.List;

import javax.persistence.Entity;

import com.voyager.enterprise.impl.logistics.entities.storage.inventory.InBoundEntity;
import com.voyager.enterprise.impl.logistics.entities.storage.inventory.OutBoundEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class InventoryEntity {
	public Code<String> code;

    // formato de organização
    // Aberto
    // Prateleiras
    // Pilhas

    public List<InBoundEntity> listInBound;
    public List<OutBoundEntity> listOutBound;
}
