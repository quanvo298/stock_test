package com.stock.api.resources;

public class AverageItemResource {
   private String ticker;
   private Double avg;

   public String getTicker() {
      return ticker;
   }

   public void setTicker(String ticker) {
      this.ticker = ticker;
   }

   public Double getAvg() {
      return avg;
   }

   public void setAvg(Double avg) {
      this.avg = avg;
   }
}
