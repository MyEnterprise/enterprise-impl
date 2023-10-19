package com.voyager.enterprise.impl.logistics.entities.distribution;

import java.util.List;
import java.util.UUID;

import com.voyager.enterprise.impl.logistics.entities.distribution.transport.TransportStatusEntity;
import com.voyager.enterprise.logistics.entity.distribution.transport.enums.TransportEnum;

public class TransportEntity {
	public UUID id;
    public String carrier;
    public TransportEnum type;
    public List<TransportStatusEntity> listStatus;
    public AddressEntity originAdress;
    public AddressEntity destinyAddress;
    public String desc;
}
