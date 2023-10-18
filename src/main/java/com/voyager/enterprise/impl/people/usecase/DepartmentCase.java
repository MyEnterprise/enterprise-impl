package com.voyager.enterprise.impl.people.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.impl.people.ServerPeople;
import com.voyager.enterprise.people.entity.Department;
import com.voyager.enterprise.people.usercase.CaseDepartment;

public class DepartmentCase implements CaseDepartment{
	
	private ServerPeople sp;

	public DepartmentCase(ServerPeople sp) { this.sp = sp; }

    @Override
    public Department create(Department arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Department findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Department findByPredicate(Predicate<Department> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Department> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Department arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Department update(Department arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
