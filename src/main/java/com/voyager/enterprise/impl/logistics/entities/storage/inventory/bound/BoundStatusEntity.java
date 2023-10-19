package com.voyager.enterprise.impl.logistics.entities.storage.inventory.bound;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.voyager.enterprise.logistics.entity.storage.inventory.bound.enums.BoundStatusEnum;

public class BoundStatusEntity {
    public UUID id;
    public BoundStatusEnum status;
    public String desc;
    public LocalDate dt;
    public Map<String,String> attributes;
}
