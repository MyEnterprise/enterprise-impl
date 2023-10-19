package com.voyager.enterprise.impl.operation.entities.jobs.tasks;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.voyager.enterprise.operation.entity.jobs.tasks.enums.TaskStatusEnum;

public class TaskStatusEntity {
	public UUID id;
    public TaskStatusEnum status;
    public String desc;
    public LocalDate dt;
    public Map<String,String> attributes;
}
