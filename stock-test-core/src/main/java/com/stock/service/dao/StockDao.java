package com.stock.service.dao;

import java.util.Date;
import java.util.List;

import com.stock.exception.StockException;
import com.stock.model.Ticker;

public interface StockDao {

   public Ticker retreiveTransactions(String tickerCode, Date startDate, Date endDate) throws StockException;
   
   public List<Ticker> retreiveTransactions(List<String> tickerCode, Date startDate, Date endDate) throws StockException;
   
   public List<String> getTickers() throws StockException;
}
