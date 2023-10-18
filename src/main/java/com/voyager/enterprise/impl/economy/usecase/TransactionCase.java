package com.voyager.enterprise.impl.economy.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.economy.entity.Transaction;
import com.voyager.enterprise.economy.usercase.CaseTransaction;
import com.voyager.enterprise.impl.economy.ServerEconomy;

public class TransactionCase implements CaseTransaction{

	private ServerEconomy se;
	
	public TransactionCase(ServerEconomy se) {
		this.se = se;
	}
	
    @Override
    public Transaction create(Transaction arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Transaction findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Transaction findByPredicate(Predicate<Transaction> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Transaction> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Transaction arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Transaction update(Transaction arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
