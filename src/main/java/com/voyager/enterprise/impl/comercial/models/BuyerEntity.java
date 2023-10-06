package com.voyager.enterprise.impl.comercial.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;

@Entity
public class BuyerEntity{

	@Id
	long id;

	@NotNull
	@Length(100)
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
