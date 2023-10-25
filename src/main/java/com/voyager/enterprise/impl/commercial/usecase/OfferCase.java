package com.voyager.enterprise.impl.commercial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.commercial.entity.Offer;
import com.voyager.enterprise.commercial.usercase.CaseOffer;
import com.voyager.enterprise.impl.commercial.ServerCommercial;

public class OfferCase implements CaseOffer{
	
	private ServerCommercial sc;
	
	public OfferCase(ServerCommercial sc) {
		this.sc = sc;
	}
	
    @Override
    public Offer create(Offer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Offer findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Offer findByPredicate(Predicate<Offer> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Offer> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Offer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Offer update(Offer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
