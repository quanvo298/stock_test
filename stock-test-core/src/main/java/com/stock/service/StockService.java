package com.stock.service;

import java.util.Date;
import java.util.List;

import com.stock.dto.TickerDto;
import com.stock.exception.StockException;

public interface StockService {

   public TickerDto getTransaction(String tickerCode, Date startDate, Date endDate) throws StockException;

   public TickerDto getAverage (String tickerCode, Date startDate, int plusDays) throws StockException;
   
   public List<TickerDto> getAverage (List<String> tickerCodes, Date startDate, int plusDays) throws StockException;
   
   public List<String> getTickers() throws StockException;
}
