package com.voyager.enterprise.impl.logistics.entities.distribution.expedition;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;

import com.voyager.enterprise.logistics.entity.distribution.expedition.enums.ExpeditionStatusEnum;

@Entity
public class ExpeditionStatusEntity {
    public UUID id;
    public ExpeditionStatusEnum status;
    public String desc;
    public LocalDate dt;
    public Map<String,String> attributes;
}
