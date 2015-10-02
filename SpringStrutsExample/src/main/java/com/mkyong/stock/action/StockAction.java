package com.mkyong.stock.action;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Stock;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.template.utility.ToCanonical;

@Namespace("/")
@Results({
	   @Result(name="success",location="stock.jsp"),
	   @Result(name="edit", location="edit.jsp")
	})
public class StockAction extends ActionSupport implements ModelDriven{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String stockCodeKwd;
	
	StockBo stockBo;
 
	Stock stock = new Stock();
	List<Stock> stockList = new ArrayList<Stock>();
 
	@Autowired
	public void setStockBo(StockBo StockBo) {
		this.stockBo = StockBo;
	}
 
	public Object getModel() {
		return stock;
	}
 
	public List<Stock> getStockList() {
		return stockList;
	}
 
	public void setStockList(List<Stock> StockList) {
		this.stockList = StockList;
	}
 
	//save Stock
	@Action(value = "/addStockAction")
	public String addStock() throws Exception{
		stock.setCreatedDate(new Date());
		//save it
		stockBo.addStock(stock);
		
		//reload the Stock list
		stockList = null;
		stockList = stockBo.listStock();
 
		return "success";
 
	}
 
	//list all Stocksaaaaa
	@Action(value = "/listStockAction")
	public String listStock() throws Exception{
 
		stockList = stockBo.listStock();
 
		return "success";
 
	}
	
	@Action(value = "/deleteStockAction")
	public String deleteStock() throws Exception{
		System.out.println("Hien Debug :....................");
		System.out.println("Hien Debug :....................");
		Stock ob = stockBo.findByStockCode(stock.getStockCode());
		stockBo.delete(ob);
		stockList = stockBo.listStock();
		return "success";
 
	}
	
	//list all Stocks
	@Action(value = "/searchStockAction")
	public String searchStock() throws Exception{
			stockList = new ArrayList<Stock>();
			Stock obj = null;
			if(stockCodeKwd == null || stockCodeKwd.trim().equals("") ) {
				stockList = stockBo.listStock();
				return "success";
			} else {
				obj = stockBo.findByStockCode(stockCodeKwd);
			}
			
			if(obj != null) {
				stockList.add(obj);
			}
			
			return "success";
	}
	
	 public String execute() throws Exception {
		 	
		 	stockList = stockBo.listStock();
			return "success";
	 
		}
}