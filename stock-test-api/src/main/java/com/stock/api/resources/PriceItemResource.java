package com.stock.api.resources;

import java.util.List;

public class PriceItemResource {
   private String ticker;
   private List<Object[]> dateClose;

   public String getTicker() {
      return ticker;
   }

   public void setTicker(String ticker) {
      this.ticker = ticker;
   }

   public List<Object[]> getDateClose() {
      return dateClose;
   }

   public void setDateClose(List<Object[]> dateClose) {
      this.dateClose = dateClose;
   }

}
