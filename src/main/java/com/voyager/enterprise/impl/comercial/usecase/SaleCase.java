package com.voyager.enterprise.impl.comercial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.commercial.entity.Sale;
import com.voyager.enterprise.commercial.usercase.CaseSale;

public class SaleCase implements CaseSale{

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
