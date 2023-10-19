package com.voyager.enterprise.impl.logistics.entities.distribution;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class AddressEntity {
	public UUID id;
    public boolean main;
    public String country;
    public String stateOrProvince;
    public String city;
    public String districtOrBurgh;
    public String street;
    public String number;
}
