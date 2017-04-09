package com.stock.core;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stock.ServiceApplication;
import com.stock.dto.TickerDto;
import com.stock.exception.StockException;
import com.stock.service.StockService;
import com.stock.service.quandl.RestConvert;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={ServiceApplication.class})
public class StockServiceTest {
   
   @Autowired
   private StockService stockService;
   
   @Test
   public void testGetTransactions() throws StockException, ParseException{
      Date startDate = RestConvert.convert("2017-01-01");
      Date endDate = RestConvert.convert("2017-31-03");
      TickerDto ticker = this.stockService.getTransaction("GE", startDate, endDate);
      Assert.assertNotNull(ticker);
      Assert.assertEquals("GE", ticker.getName());
      Assert.assertTrue(ticker.getTransactions().size() > 0);
   }
   
   @Test
   public void testGetTransactionsAverage() throws StockException, ParseException{
      Date startDate = RestConvert.convert("2017-01-03");
      TickerDto ticket = this.stockService.getAverage("GE", startDate, 200);
      Assert.assertNotNull(ticket);
      Assert.assertEquals("GE", ticket.getName());
      Assert.assertTrue(ticket.getAvg() > 0);
   }
   
   @Test
   public void testGetMoreTransactionsAverage() throws StockException, ParseException{
      Date startDate = RestConvert.convert("2017-01-03");
      List<String> tickerCodes = new ArrayList<String>(1);
      tickerCodes.add("GE");
      List<TickerDto> tickets = this.stockService.getAverage(tickerCodes, startDate, 200);
      Assert.assertNotNull(tickets);
      Assert.assertTrue(tickets.size() > 0);
   }
}
