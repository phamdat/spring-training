package com.mkyong.stock.bo;
 
import java.util.List;

import com.mkyong.stock.model.Stock;
 //1111
public interface StockBo {
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
	void addStock(Stock stock);
	List<Stock> listStock();
}