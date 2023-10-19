package com.voyager.enterprise.impl.entities;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

@Entity
public class EnterpriseEntity extends PersonEntity{
	private String code;
	private String name;
	private List<String> listSegment;
	private Map<String, String> attributes;
}
