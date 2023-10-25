package com.voyager.enterprise.impl.domain.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.util.Code;

@Entity
public class OfficeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@OneToOne
    private ResourceEntity resource;
	@Column
    private String role;
	@Column
    private BigDecimal salary;
	@OneToOne
    private DepartmentEntity department;
	@Column
    private String dtStart;
	@Column
    private String dtEnd;
	@OneToMany(cascade = CascadeType.ALL)
    private List<PaymentEmployeeEntity> listPayment;

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
    public ResourceEntity getResource() {
        return resource;
    }
    public void setResource(ResourceEntity resource) {
        this.resource = resource;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public DepartmentEntity getDepartment() {
        return department;
    }
    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
    public String getDtStart() {
        return dtStart;
    }
    public void setDtStart(String dtStart) {
        this.dtStart = dtStart;
    }
    public String getDtEnd() {
        return dtEnd;
    }
    public void setDtEnd(String dtEnd) {
        this.dtEnd = dtEnd;
    }
    public List<PaymentEmployeeEntity> getListPayment() {
        return listPayment;
    }
    public void setListPayment(List<PaymentEmployeeEntity> listPayment) {
        this.listPayment = listPayment;
    }

}
