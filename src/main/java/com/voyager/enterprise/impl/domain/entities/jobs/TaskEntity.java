package com.voyager.enterprise.impl.domain.entities.jobs;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.impl.domain.entities.jobs.tasks.TaskStatusEntity;
import com.voyager.enterprise.impl.domain.entities.EmployeeEntity;
import com.voyager.enterprise.util.Code;

@Entity
public class TaskEntity {
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
	private EmployeeEntity responsible;
	@OneToMany(cascade = CascadeType.ALL)
	private List<TaskStatusEntity> listStatus;
	@Column
	private LocalDate start;
	@Column
	private LocalDate end;

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
	public EmployeeEntity getResponsible() {
		return responsible;
	}
	public void setResponsible(EmployeeEntity responsible) {
		this.responsible = responsible;
	}
	public List<TaskStatusEntity> getListStatus() {
		return listStatus;
	}
	public void setListStatus(List<TaskStatusEntity> listStatus) {
		this.listStatus = listStatus;
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}

	
}
