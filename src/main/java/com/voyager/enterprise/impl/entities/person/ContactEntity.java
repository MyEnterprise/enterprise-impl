package com.voyager.enterprise.impl.entities.person;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class ContactEntity {
	private UUID id;
	private String fax;
	private String fone;
	private String mail;
	private String desc;
	private boolean main;
	private String website;
}
