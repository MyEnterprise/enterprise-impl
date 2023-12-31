package com.voyager.enterprise.impl.domain.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.impl.domain.entities.jobs.JobStatusEntity;
import com.voyager.enterprise.impl.domain.entities.jobs.TaskEntity;
import com.voyager.enterprise.util.Code;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class JobEntity extends OrderEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MerchandiseEntity> feedstocks;
	@OneToMany(cascade = CascadeType.ALL)
	private List<TaskEntity> tasks;
	@OneToMany(cascade = CascadeType.ALL)
	private List<JobStatusEntity> listStatus;

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
	public List<MerchandiseEntity> getFeedstocks() {
		return feedstocks;
	}
	public void setFeedstocks(List<MerchandiseEntity> feedstocks) {
		this.feedstocks = feedstocks;
	}
	public List<TaskEntity> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}
	public List<JobStatusEntity> getListStatus() {
		return listStatus;
	}
	public void setListStatus(List<JobStatusEntity> listStatus) {
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
