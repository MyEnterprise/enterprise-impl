package com.voyager.enterprise.impl.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.voyager.enterprise.impl.entities.person.ContactEntity;
import com.voyager.enterprise.impl.logistics.entities.distribution.AddressEntity;
import com.voyager.enterprise.impl.plugin.tax.entities.TaxIdentificationEntity;
import com.voyager.enterprise.plugin.tax.entity.TaxIdentification;

import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull
	@Length(100)
	private String name;

	private TaxIdentificationEntity identification;
	private List<AddressEntity> listAddress;
	private List<ContactEntity> listContact;
	
}
