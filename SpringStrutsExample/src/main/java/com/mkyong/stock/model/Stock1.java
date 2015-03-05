package com.mkyong.stock.model;

import java.io.Serializable;
import java.util.Date;

public class Stock1 implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Long stockId;
	private String stockCode;
	private String stockName;
	private Date createdDate;
	
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
 
	//getter and setter methods...
}