package com.voyager.enterprise.impl.logistics.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.logistics.entity.distribution.expedition.ExpeditionStatus;
import com.voyager.enterprise.logistics.usercase.CaseExpeditionStatus;

public class ExpeditionStatusCase implements CaseExpeditionStatus{

    @Override
    public ExpeditionStatus create(ExpeditionStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ExpeditionStatus findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ExpeditionStatus findByPredicate(Predicate<ExpeditionStatus> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<ExpeditionStatus> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(ExpeditionStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public ExpeditionStatus update(ExpeditionStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
