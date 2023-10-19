package com.voyager.enterprise.impl.operation.entities;

import java.time.LocalDate;
import java.util.List;

import com.voyager.enterprise.impl.comercial.entities.OrderEntity;
import com.voyager.enterprise.impl.economy.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.operation.entities.jobs.JobStatusEntity;
import com.voyager.enterprise.impl.operation.entities.jobs.TaskEntity;

public class JobEntity extends OrderEntity{
	private List<MerchandiseEntity> feedstocks;
	private List<TaskEntity> tasks;
	private List<JobStatusEntity> listStatus;
	private LocalDate start;
	private LocalDate end;
}
