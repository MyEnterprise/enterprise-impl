package com.voyager.enterprise.impl.commercial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.commercial.entity.Order;
import com.voyager.enterprise.commercial.usercase.CaseOrder;
import com.voyager.enterprise.impl.commercial.ServerCommercial;

public class OrderCase implements CaseOrder {
	
	private ServerCommercial sc;
	
	public OrderCase(ServerCommercial sc) {
		this.sc = sc;
	}

    @Override
    public Order create(Order arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Order findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Order findByPredicate(Predicate<Order> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Order> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Order arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Order update(Order arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
