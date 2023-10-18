package com.voyager.enterprise.impl.financial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.financial.entity.Wallet;
import com.voyager.enterprise.financial.usercase.CaseWallet;
import com.voyager.enterprise.impl.financial.ServerFinancial;

public class WalletCase implements CaseWallet{

	private ServerFinancial sf;

	public WalletCase(ServerFinancial sf) {	this.sf = sf; }

    @Override
    public Wallet create(Wallet arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Wallet findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Wallet findByPredicate(Predicate<Wallet> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Wallet> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Wallet arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Wallet update(Wallet arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
