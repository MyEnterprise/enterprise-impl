package com.voyager.enterprise.impl.financial.usecase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.voyager.enterprise.financial.entity.Book;
import com.voyager.enterprise.financial.usercase.CaseBook;
import com.voyager.enterprise.impl.economy.ServerEconomy;
import com.voyager.enterprise.impl.financial.ServerFinancial;

public class BookCase implements CaseBook{

	private ServerFinancial sf;

	public BookCase(ServerFinancial sf) {
		this.sf = sf;
	}

    @Override
    public Book create(Book arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Book findById(UUID arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Book findByPredicate(Predicate<Book> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPredicate'");
    }

    @Override
    public List<Book> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public void remove(Book arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Book update(Book arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Book mountBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mountBook'");
    }
    
}
