package com.stock.service.dao.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.stock.exception.StockException;
import com.stock.model.Ticker;
import com.stock.service.dao.StockDao;
import com.stock.service.quandl.RestClient;

@Service
public class DefaultStockDao implements StockDao {

   @Autowired
   private RestClient restClient;

   @Override
   public Ticker retreiveTransactions(String tickerCode, Date startDate, Date endDate) throws StockException {
      try {
         return restClient.retreiveTransactions(startDate, endDate);
      } catch (IOException | ParseException exception) {
         throw new StockException(exception.getMessage(), exception);
      }
   }

   @Override
   public List<Ticker> retreiveTransactions(List<String> tickerCodes, Date startDate, Date endDate)
         throws StockException {
      try {
         List<Ticker> tickers = new ArrayList<Ticker>(tickerCodes.size());
         for (String tickerCode : tickerCodes){
            if ("GE".equals(tickerCode)){
               tickers.add(restClient.retreiveTransactions(startDate, endDate));
            }else {
               tickers.add(createSample(tickerCode));
            }
         }
         return tickers;
      } catch (IOException | ParseException exception) {
         throw new StockException(exception.getMessage(), exception);
      }
   }

   @Override
   public List<String> getTickers() throws StockException {
      return Arrays.asList("GE");
   }

   private Ticker createSample(String tickerCode){
      Ticker ticker = new Ticker();
      ticker.setName(tickerCode);
      return ticker;
   }

   @Override
   @Cacheable(cacheNames = "closeDatesTikcerCache", key = "#tickerCode")
   public Ticker getTicker(String tickerCode) throws StockException {
      try {
         return this.restClient.retreiveTransactions();
      } catch (IOException | ParseException exception) {
         throw new StockException(exception.getMessage(), exception);
      }
   }
}
