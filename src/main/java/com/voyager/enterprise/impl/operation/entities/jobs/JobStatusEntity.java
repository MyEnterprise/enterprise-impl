package com.voyager.enterprise.impl.operation.entities.jobs;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.voyager.enterprise.operation.entity.jobs.enums.JobStatusEnum;

public class JobStatusEntity {
	public UUID id;
    public JobStatusEnum status;
    public String desc;
    public LocalDate dt;
    public Map<String,String> attributes;
}
