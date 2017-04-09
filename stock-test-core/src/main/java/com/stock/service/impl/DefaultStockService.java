package com.stock.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dto.TickerDto;
import com.stock.exception.StockException;
import com.stock.mapper.StockMapper;
import com.stock.model.Ticker;
import com.stock.model.Transaction;
import com.stock.service.StockService;
import com.stock.service.dao.StockDao;
import com.stock.util.DateTimeUtils;

@Service
public class DefaultStockService implements StockService {

   @Autowired
   private StockDao stockDao;
   
   @Override
   public TickerDto getTransaction(String tickerCode, Date startdate, Date endDate) throws StockException {
      if (tickerCode == null || startdate == null || endDate == null){
         return null;
      }
      return StockMapper.convertToDto(stockDao.retreiveTransactions(tickerCode, startdate, endDate));
   }

   @Override
   public TickerDto getAverage(String tickerCode, Date startDate, int plusDays) throws StockException {
      if (tickerCode == null || startDate == null || plusDays < 0){
         return null;
      }
      Date endDate = DateTimeUtils.plusDate(startDate, plusDays);
      Ticker ticket = stockDao.retreiveTransactions(tickerCode, startDate, endDate);
      List<Transaction> transactions = ticket.getTransactions();
      Double avg = transactions.stream().mapToDouble(Transaction::getPrice).average().getAsDouble();
      TickerDto tickerDto = new TickerDto();
      tickerDto.setId(ticket.getId());
      tickerDto.setName(ticket.getName());
      tickerDto.setAvg(avg);
      return tickerDto;
   }

   @Override
   public List<TickerDto> getAverage(List<String> tickerCodes, Date startDate, int plusDays) throws StockException {
      if (CollectionUtils.isEmpty(tickerCodes) || startDate == null || plusDays < 0){
         return null;
      }
      Date endDate = DateTimeUtils.plusDate(startDate, plusDays);
      List<Ticker> tickers = this.stockDao.retreiveTransactions(tickerCodes, startDate, endDate);
      List<TickerDto> tickerDtos = new ArrayList<TickerDto>(tickerCodes.size());
      tickers.forEach(ticker -> {
         TickerDto tickerDto = new TickerDto();
         tickerDto.setId(ticker.getId());
         tickerDto.setName(ticker.getName());
         if (ticker.getTransactions() != null){
            Double avg = ticker.getTransactions().stream().mapToDouble(Transaction::getPrice).average().getAsDouble();
            tickerDto.setAvg(avg);
         }
         tickerDtos.add(tickerDto);
      });
      return tickerDtos;
   }

   @Override
   public List<String> getTickers() throws StockException {
      return this.stockDao.getTickers();
   }
}
