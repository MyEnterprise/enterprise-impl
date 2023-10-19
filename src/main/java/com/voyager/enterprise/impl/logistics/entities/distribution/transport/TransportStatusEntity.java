package com.voyager.enterprise.impl.logistics.entities.distribution.transport;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.voyager.enterprise.logistics.entity.distribution.transport.enums.TransportStatusEnum;

public class TransportStatusEntity {
	public UUID id;
    public TransportStatusEnum status;
    public String desc;
    public LocalDate dt;
    public Map<String, String> attributes;
}
