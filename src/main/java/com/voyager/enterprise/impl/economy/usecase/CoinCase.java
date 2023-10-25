package com.voyager.enterprise.impl.economy.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.economy.entity.merchandise.Coin;
import com.voyager.enterprise.economy.usercase.CaseCoin;
import com.voyager.enterprise.impl.economy.ServerEconomy;

public class CoinCase implements CaseCoin {
	
	private ServerEconomy se;
	
	public CoinCase(ServerEconomy se) {
		this.se = se;
	}

    @Override
    public Coin create(Coin arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Coin findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Coin findByPredicate(Predicate<Coin> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Coin> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Coin arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Coin update(Coin arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
