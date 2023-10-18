package com.voyager.enterprise.impl.operation.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.operation.entity.jobs.JobStatus;
import com.voyager.enterprise.operation.usercase.CaseJobStatus;

public class JobStatusCase implements CaseJobStatus{
	
	private ServerOperation so;

	public JobStatusCase(ServerOperation so) { this.so = so; }
	
    @Override
    public JobStatus create(JobStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public JobStatus findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public JobStatus findByPredicate(Predicate<JobStatus> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<JobStatus> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(JobStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public JobStatus update(JobStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
