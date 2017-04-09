package com.stock.api.resources;

import java.util.ArrayList;
import java.util.List;

import com.stock.dto.TickerDto;

public class AverageResources {
   private List<AverageItemResource> dma;

   public List<AverageItemResource> getDma() {
      return dma;
   }
   public void setDma(List<AverageItemResource> dma) {
      this.dma = dma;
   }


   public static AverageResources convert(List<TickerDto> tickerDtos){
      AverageItemResource averageItemResource = null;
      List<AverageItemResource> averageItemResources = new ArrayList<AverageItemResource>(tickerDtos.size());
      for (TickerDto tickerDto : tickerDtos){
         averageItemResource = new AverageItemResource();
         averageItemResource.setAvg(tickerDto.getAvg());
         averageItemResource.setTicker(tickerDto.getName());
         averageItemResources.add(averageItemResource);
      }

      AverageResources averageResource = new AverageResources();
      averageResource.setDma(averageItemResources);
      return averageResource;
   }
}
