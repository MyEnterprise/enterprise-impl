package com.voyager.enterprise.impl.logistics.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.logistics.entity.storage.WareHouse;
import com.voyager.enterprise.logistics.usercase.CaseWareHouse;

public class WareHouseCase implements CaseWareHouse{
	
	private ServerLogistics sl;

	public WareHouseCase(ServerLogistics sl) {	this.sl = sl; }

    @Override
    public WareHouse create(WareHouse arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public WareHouse findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public WareHouse findByPredicate(Predicate<WareHouse> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<WareHouse> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(WareHouse arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public WareHouse update(WareHouse arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
