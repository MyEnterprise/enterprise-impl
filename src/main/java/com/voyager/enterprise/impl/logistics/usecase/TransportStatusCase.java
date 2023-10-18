package com.voyager.enterprise.impl.logistics.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.logistics.entity.distribution.transport.TransportStatus;
import com.voyager.enterprise.logistics.usercase.CaseTransportStatus;

public class TransportStatusCase implements CaseTransportStatus{

	private ServerLogistics sl;

	public TransportStatusCase(ServerLogistics sl) { this.sl = sl; }
	
    @Override
    public TransportStatus create(TransportStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TransportStatus findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TransportStatus findByPredicate(Predicate<TransportStatus> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<TransportStatus> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(TransportStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public TransportStatus update(TransportStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
