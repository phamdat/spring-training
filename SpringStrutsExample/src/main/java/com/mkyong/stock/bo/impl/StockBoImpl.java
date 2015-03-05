package com.mkyong.stock.bo.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.dao.StockDao;
import com.mkyong.stock.model.Stock;

@Service
@Transactional
public class StockBoImpl implements StockBo{
 
	@Autowired
	StockDao stockDao;
 
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}
 
	public void update(Stock stock){
		stockDao.update(stock);
	}
 
	public void delete(Stock stock){
		stockDao.delete(stock);
	}
 
	public Stock findByStockCode(String stockCode){
		Stock ob = stockDao.findByStockCode(stockCode);
		return ob ; //stockDao.findByStockCode(stockCode);
	}

 
	//call DAO to save Stock
	public void addStock(Stock stock){
		stockDao.addStock(stock);
	}
 
	//call DAO to return Stocks
	public List<Stock> listStock(){
		return stockDao.listStock();
	}
}