package com.voyager.enterprise.impl.commercial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.commercial.entity.Purchase;
import com.voyager.enterprise.commercial.usercase.CasePurchase;
import com.voyager.enterprise.impl.commercial.ServerCommercial;

public class PurchaseCase implements CasePurchase{

	private ServerCommercial sc;
	
	public PurchaseCase(ServerCommercial sc) {
		this.sc = sc;
	}
	
    @Override
    public Purchase create(Purchase arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Purchase findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Purchase findByPredicate(Predicate<Purchase> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Purchase> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Purchase arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Purchase update(Purchase arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
