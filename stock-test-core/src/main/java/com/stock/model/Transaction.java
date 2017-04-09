package com.stock.model;

import java.util.Date;

public class Transaction {
   private Date closeDate;
   private Ticker ticket;
   private Double price;

   public Date getCloseDate() {
      return closeDate;
   }

   public void setCloseDate(Date closeDate) {
      this.closeDate = closeDate;
   }

   public Ticker getTicket() {
      return ticket;
   }

   public void setTicket(Ticker ticket) {
      this.ticket = ticket;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }
}