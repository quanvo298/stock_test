package com.stock.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.api.resources.AverageResource;
import com.stock.api.resources.AverageResources;
import com.stock.api.resources.PriceResource;
import com.stock.dto.TickerDto;
import com.stock.exception.StockException;
import com.stock.service.StockService;

@RestController
@RequestMapping("/")
public class StockController {

   @Autowired
   private StockService stockService;
   
   
   @RequestMapping(value="/api/v2/{ticker}/closePrice", method=RequestMethod.GET)
   public PriceResource getTicker(final @PathVariable("ticker") String ticker, 
         @RequestParam(name="startDate", required=false) @DateTimeFormat(pattern="yyyy-mm-dd") final Date startDate,
         @RequestParam(name="endDate", required=false) @DateTimeFormat(pattern="yyyy-mm-dd") final Date endDate) throws StockException{
      TickerDto tickerDto = null;
      if (startDate == null || endDate == null){
         tickerDto = this.stockService.getTicker(ticker);
      }else {
         tickerDto = this.stockService.getTransaction(ticker, startDate, endDate);
      }
      return PriceResource.convert(tickerDto);
   }
   
   @RequestMapping(value="/api/v2/{ticker}/200dma", method=RequestMethod.GET)
   public AverageResource getAverage(final @PathVariable("ticker") String ticker, 
         @RequestParam(name="startDate", required=true) @DateTimeFormat(pattern="yyyy-mm-dd") final Date startDate) throws StockException{
      TickerDto tickerDto = this.stockService.getAverage(ticker, startDate, 200);
      return AverageResource.convert(tickerDto);
   }
   
   @RequestMapping(value="/api/v2/200dma", method=RequestMethod.GET)
   public AverageResources getAverages(@RequestParam(name="startDate", required=true) @DateTimeFormat(pattern="yyyy-mm-dd") final Date startDate) throws StockException{
      List<String> tickers = this.stockService.getTickers();
      List<TickerDto> tickerDtos = this.stockService.getAverage(tickers, startDate, 200);
      return AverageResources.convert(tickerDtos);
   }
}
