package com.mkyong.stock.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
 
@Entity
@Table(name = "stock_detail", catalog = "mkyong")
public class StockDetail implements java.io.Serializable {
 
	private Integer stockId;
	private Stock stock;
	private String compName;
	private String compDesc;
 
	public StockDetail() {
	}
 
	public StockDetail(Stock stock, String compName, String compDesc,
			String remark, Date listedDate) {
		this.stock = stock;
		this.compName = compName;
		this.compDesc = compDesc;
	}
 
	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "stock"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}
 
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
 
	@OneToOne
	@PrimaryKeyJoinColumn
	public Stock getStock() {
		return this.stock;
	}
 
	public void setStock(Stock stock) {
		this.stock = stock;
	}
 
	@Column(name = "COMP_NAME", nullable = false, length = 100)
	public String getCompName() {
		return this.compName;
	}
 
	public void setCompName(String compName) {
		this.compName = compName;
	}
 
	@Column(name = "COMP_DESC", nullable = false)
	public String getCompDesc() {
		return this.compDesc;
	}
 
	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}
 
 
}