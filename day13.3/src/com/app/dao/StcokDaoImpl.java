package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Stock;

@Repository // MANDATORY
@Transactional // MANDATORY
public class StcokDaoImpl implements IStockDao {
	// dep
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public List<Stock> listAllStocks() {
		String jpql = "select s from Stock s";
		return sf.getCurrentSession().createQuery(jpql, Stock.class).getResultList();
	}

}
