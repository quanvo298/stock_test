package com.stock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TickerDto {
   private Long id;
   private String name;
   private List<TransactionDto> transactions;
   private Double avg; 

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<TransactionDto> getTransactions() {
      return transactions;
   }

   public void setTransactions(List<TransactionDto> transactions) {
      this.transactions = transactions;
   }

   public Double getAvg() {
      return avg;
   }

   public void setAvg(Double avg) {
      this.avg = avg;
   }
}