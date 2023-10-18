package com.voyager.enterprise.impl.economy.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.economy.entity.lending.Fee;
import com.voyager.enterprise.economy.usercase.CaseFee;
import com.voyager.enterprise.impl.economy.ServerEconomy;

public class FeeCase implements CaseFee{

	private ServerEconomy se;
	
	public FeeCase(ServerEconomy se) {
		this.se = se;
	}
	
    @Override
    public Fee create(Fee arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Fee findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Fee findByPredicate(Predicate<Fee> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Fee> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Fee arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Fee update(Fee arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
