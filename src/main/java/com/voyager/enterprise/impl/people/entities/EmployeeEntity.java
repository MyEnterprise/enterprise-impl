package com.voyager.enterprise.impl.people.entities;

import java.time.LocalDate;
import java.util.List;

import com.voyager.enterprise.impl.entities.PersonEntity;

public class EmployeeEntity extends PersonEntity{
	public List<OfficeEntity> office;
    public String race;
    public String code;
    public String sex;
    public LocalDate dtBirth;
}
