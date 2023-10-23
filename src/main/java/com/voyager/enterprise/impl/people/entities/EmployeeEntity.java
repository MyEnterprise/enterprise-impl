package com.voyager.enterprise.impl.people.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.voyager.enterprise.impl.entities.PersonEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class EmployeeEntity extends PersonEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@OneToMany
	private List<OfficeEntity> office;
	@Column
    private String race;
	@Column
    private String sex;
	@Column
    private LocalDate dtBirth;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Code<String> getCode() {
        return code;
    }
    public void setCode(Code<String> code) {
        this.code = code;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public List<OfficeEntity> getOffice() {
        return office;
    }
    public void setOffice(List<OfficeEntity> office) {
        this.office = office;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public LocalDate getDtBirth() {
        return dtBirth;
    }
    public void setDtBirth(LocalDate dtBirth) {
        this.dtBirth = dtBirth;
    }  
}
