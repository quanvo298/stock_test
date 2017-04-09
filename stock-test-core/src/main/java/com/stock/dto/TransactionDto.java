package com.stock.dto;

import java.util.Date;

public class TransactionDto {
   private Long id;
   private Date closeDate;
   private Long ticket;
   private Double price;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getCloseDate() {
      return closeDate;
   }

   public void setCloseDate(Date closeDate) {
      this.closeDate = closeDate;
   }

   public Long getTicket() {
      return ticket;
   }

   public void setTicket(Long ticket) {
      this.ticket = ticket;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }
}