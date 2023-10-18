package com.voyager.enterprise.impl.logistics.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.logistics.entity.distribution.Expedition;
import com.voyager.enterprise.logistics.usercase.CaseExpedition;

public class ExpeditionCase implements CaseExpedition{
	
	private ServerLogistics sl;

	public ExpeditionCase(ServerLogistics sl) {	this.sl = sl; }

    @Override
    public Expedition create(Expedition arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Expedition findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Expedition findByPredicate(Predicate<Expedition> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Expedition> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Expedition arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Expedition update(Expedition arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
