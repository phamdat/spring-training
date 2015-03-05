package com.mkyong.stock.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.stock.dao.StockDao;
import com.mkyong.stock.model.Stock;

@Repository
public class StockDaoImpl implements StockDao {
	
	
	@Autowired   
	SessionFactory sessionFactory;
    

	public void update(Stock stock) {
		sessionFactory.getCurrentSession().update(stock);
	}

	public void delete(Stock stock) {
		sessionFactory.getCurrentSession().delete(stock);
	}
	
	
	public Stock findByStockCode(String stockCode) {
//		List list = sessionFactory.getCurrentSession().get(Stock.class, stockCode)(
//				"from Stock where stockCode=?", stockCode);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Stock.class);
		return (Stock) criteria.add(Restrictions.eq("stockCode", stockCode))
		                             .uniqueResult();
//		return null;
	}
	
	// add the Stock
	public void addStock(Stock stock) {
		sessionFactory.getCurrentSession().save(stock);
	}

	// return all the Stocks in list 
	public List<Stock> listStock() {
		return sessionFactory.getCurrentSession().createQuery("from Stock").list();
	}

}