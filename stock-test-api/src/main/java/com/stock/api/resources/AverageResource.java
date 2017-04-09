package com.stock.api.resources;

import com.stock.dto.TickerDto;

public class AverageResource {
   private AverageItemResource dma;

   public AverageItemResource getDma() {
      return dma;
   }

   public void setDma(AverageItemResource dma) {
      this.dma = dma;
   }

   public static AverageResource convert(TickerDto tickerDto){
      AverageItemResource averageItemResource = new AverageItemResource();
      averageItemResource.setAvg(tickerDto.getAvg());
      averageItemResource.setTicker(tickerDto.getName());
      
      AverageResource averageResource = new AverageResource();
      averageResource.setDma(averageItemResource);
      return averageResource;
   }
}
