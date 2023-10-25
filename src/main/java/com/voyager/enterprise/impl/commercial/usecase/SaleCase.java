package com.voyager.enterprise.impl.commercial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.commercial.entity.Sale;
import com.voyager.enterprise.commercial.usercase.CaseSale;
import com.voyager.enterprise.impl.commercial.ServerCommercial;

public class SaleCase implements CaseSale{
	
	private ServerCommercial sc;
	
	public SaleCase(ServerCommercial sc) {
		this.sc = sc;
	}

    @Override
    public Sale create(Sale arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Sale findById(UUID arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Sale findByPredicate(Predicate<Sale> arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Sale> listAll() {

        throw new UnsupportedOperationException("Unimplemented method 'listAll'");

    }

    @Override
    public void remove(Sale arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Sale update(Sale arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
