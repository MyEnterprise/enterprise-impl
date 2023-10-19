package com.voyager.enterprise.impl.entities;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

@Entity
public class FusionEntity {
	private List<EnterpriseEntity> mergingEnterprise;
	private EnterpriseEntity resultingEnterprise;
	private Map<EnterpriseEntity, Double> ownershipPercentages;
}
