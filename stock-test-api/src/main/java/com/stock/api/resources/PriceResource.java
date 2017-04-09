package com.stock.api.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.stock.dto.TickerDto;
import com.stock.dto.TransactionDto;
import com.stock.service.quandl.RestConvert;

public class PriceResource {
   private List<PriceItemResource> prices;

   
   public List<PriceItemResource> getPrices() {
      return prices;
   }


   public void setPrices(List<PriceItemResource> prices) {
      this.prices = prices;
   }

   public static PriceResource convert(TickerDto tickerDto){
      PriceResource pricesResource = new PriceResource();
      pricesResource.setPrices(new ArrayList<PriceItemResource>(1));
      List<PriceItemResource> priceItemResources = pricesResource.getPrices();
      List<Object[]> dateClosed = null;
      if (CollectionUtils.isNotEmpty(tickerDto.getTransactions())){
         dateClosed = new ArrayList<Object[]>(tickerDto.getTransactions().size());
         Object[] objs = null;
         for (TransactionDto transactionDto : tickerDto.getTransactions()){
            objs = new Object[2];
            objs[0] = RestConvert.convert(transactionDto.getCloseDate());
            objs[1] = transactionDto.getPrice();
            dateClosed.add(objs);
         }
      }else {
         dateClosed = Collections.emptyList();
      }
      PriceItemResource priceItemResource = new PriceItemResource();
      priceItemResource.setTicker(tickerDto.getName());
      priceItemResource.setDateClose(dateClosed);
      priceItemResources.add(priceItemResource);
      return pricesResource;
   }
}
