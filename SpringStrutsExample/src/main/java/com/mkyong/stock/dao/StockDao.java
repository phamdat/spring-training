package com.mkyong.stock.dao;
 
import java.util.List;

import com.mkyong.stock.model.Stock;
 
public interface StockDao {
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
	void addStock(Stock stock);
	List<Stock> listStock();
 
}