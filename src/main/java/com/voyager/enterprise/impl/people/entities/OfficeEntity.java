package com.voyager.enterprise.impl.people.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import com.voyager.enterprise.impl.financial.entities.ResourceEntity;

public class OfficeEntity {
	public UUID id;
    public ResourceEntity resource;
    public String role;
    public BigDecimal salary;
    public DepartmentEntity department;
    public Properties properties;
    public String dtStart;
    public String dtEnd;
    public List<PaymentEmployeeEntity> listPayment;
}
