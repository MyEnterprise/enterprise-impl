package com.voyager.enterprise.impl.economy.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.economy.entity.transaction.TransactionStatus;
import com.voyager.enterprise.economy.usercase.CaseTransactionStatus;
import com.voyager.enterprise.impl.economy.ServerEconomy;

public class TransactionStatusCase implements CaseTransactionStatus{
	
	private ServerEconomy se;
	
	public TransactionStatusCase(ServerEconomy se) {
		this.se = se;
	}

    @Override
    public TransactionStatus create(TransactionStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TransactionStatus findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TransactionStatus findByPredicate(Predicate<TransactionStatus> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<TransactionStatus> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(TransactionStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public TransactionStatus update(TransactionStatus arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
