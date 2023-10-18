package com.voyager.enterprise.impl.financial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.financial.entity.Resource;
import com.voyager.enterprise.financial.usercase.CaseResource;
import com.voyager.enterprise.impl.financial.ServerFinancial;

public class ResourceCase implements CaseResource{
	
	private ServerFinancial sf;

	public ResourceCase(ServerFinancial sf) {
		this.sf = sf;
	}

    @Override
    public Resource create(Resource arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Resource findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Resource findByPredicate(Predicate<Resource> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Resource> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Resource arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Resource update(Resource arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
