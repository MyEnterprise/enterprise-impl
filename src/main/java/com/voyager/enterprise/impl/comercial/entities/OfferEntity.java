package com.voyager.enterprise.impl.comercial.entities;

import java.util.Map;

import com.voyager.enterprise.impl.economy.entities.MerchandiseEntity;

public class OfferEntity {
	public MerchandiseEntity merchandise;
    public String name;
    public String descr;
    public Map<String, String> attributes;
}
