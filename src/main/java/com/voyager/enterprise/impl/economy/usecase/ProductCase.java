package com.voyager.enterprise.impl.economy.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.economy.entity.merchandise.Product;
import com.voyager.enterprise.economy.usercase.CaseProduct;
import com.voyager.enterprise.impl.economy.ServerEconomy;

public class ProductCase implements CaseProduct{
	
	private ServerEconomy se;
	
	public ProductCase(ServerEconomy se) {
		this.se = se;
	}

    @Override
    public Product create(Product arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Product findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Product findByPredicate(Predicate<Product> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Product> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Product arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Product update(Product arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
