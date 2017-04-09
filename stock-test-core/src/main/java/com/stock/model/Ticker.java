package com.stock.model;

import java.util.ArrayList;
import java.util.List;

public class Ticker {
   private Long id;
   private String name;
   private List<Transaction> transactions;

   public Ticker() {
      transactions = new ArrayList<Transaction>(500);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public List<Transaction> getTransactions() {
      return transactions;
   }

   public void setTransactions(List<Transaction> transactions) {
      this.transactions = transactions;
   }

   public void add(Transaction transaction) {
      transaction.setTicket(this);
      transactions.add(transaction);
   }

}