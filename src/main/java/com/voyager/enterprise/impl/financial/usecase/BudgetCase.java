package com.voyager.enterprise.impl.financial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.financial.entity.Budget;
import com.voyager.enterprise.financial.usercase.CaseBudget;
import com.voyager.enterprise.impl.financial.ServerFinancial;

public class BudgetCase implements CaseBudget{
	
	private ServerFinancial sf;

	public BudgetCase(ServerFinancial sf) {
		this.sf = sf;
	}

    @Override
    public Budget create(Budget arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Budget findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Budget findByPredicate(Predicate<Budget> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Budget> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Budget arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Budget update(Budget arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Budget mountBudget() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mountBudget'");
    }
    
}
