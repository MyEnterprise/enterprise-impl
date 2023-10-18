package com.voyager.enterprise.impl.logistics.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.logistics.entity.storage.Inventory;
import com.voyager.enterprise.logistics.usercase.CaseInventoy;

public class InventoryCase implements CaseInventoy{
	
	private ServerLogistics sl;

	public InventoryCase(ServerLogistics sl) {	this.sl = sl; }

    @Override
    public Inventory create(Inventory arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Inventory findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Inventory findByPredicate(Predicate<Inventory> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Inventory> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Inventory arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Inventory update(Inventory arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
