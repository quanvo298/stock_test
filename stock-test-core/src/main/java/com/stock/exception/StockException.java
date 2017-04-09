package com.stock.exception;

public class StockException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 5672431697380037242L;

   public StockException(String message, Throwable throwable){
      super(message, throwable);
   }
}
