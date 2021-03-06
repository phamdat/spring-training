package com.mkyong.stock.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
@Entity
@Table(name = "stock", catalog = "mkyong", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Long stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;
	
	private Date createdDate;
	public Stock() {
	}
 
	public Stock(String stockCode, String stockName, Date createdDate) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.createdDate = createdDate;
	}
 
	public Stock(String stockCode, String stockName, StockDetail stockDetail, Date createdDate) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
		this.createdDate = createdDate;
	}
 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	@Column(name = "STOCK_NAME", unique = false, nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	@Column(name = "CREATED_DATE", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@OneToOne(mappedBy = "stock", cascade = CascadeType.ALL)
	public StockDetail getStockDetail() {
		return stockDetail;
	}
	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}
 
	//getter and setter methods...
}