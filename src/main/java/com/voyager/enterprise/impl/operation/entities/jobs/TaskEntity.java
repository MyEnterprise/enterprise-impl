package com.voyager.enterprise.impl.operation.entities.jobs;

import java.time.LocalDate;
import java.util.List;

import com.voyager.enterprise.impl.operation.entities.jobs.tasks.TaskStatusEntity;
import com.voyager.enterprise.impl.people.entities.EmployeeEntity;

public class TaskEntity {
	private String desc;
	private EmployeeEntity responsible;
	private List<TaskStatusEntity> listStatus;
	private LocalDate start;
	private LocalDate end;
}
