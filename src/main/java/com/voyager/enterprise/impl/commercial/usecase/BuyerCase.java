package com.voyager.enterprise.impl.commercial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.commercial.entity.Buyer;
import com.voyager.enterprise.commercial.usercase.CaseBuyer;
import com.voyager.enterprise.impl.commercial.ServerCommercial;

public class BuyerCase implements CaseBuyer{

	private ServerCommercial sc;

	public BuyerCase(ServerCommercial sc) {	this.sc = sc; }

    @Override
    public Buyer create(Buyer arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Buyer findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Buyer findByPredicate(Predicate<Buyer> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Buyer> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Buyer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Buyer update(Buyer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
