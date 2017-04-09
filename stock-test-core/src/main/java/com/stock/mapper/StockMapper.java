package com.stock.mapper;

import java.util.ArrayList;
import java.util.List;

import com.stock.dto.TickerDto;
import com.stock.dto.TransactionDto;
import com.stock.model.Ticker;
import com.stock.model.Transaction;

public class StockMapper {
   public static List<TransactionDto> convertToTransactionDtos(List<Transaction> models){
      if (models == null){
         return null;
      }
      List<TransactionDto> transactionDtos = new ArrayList<TransactionDto>(models.size());
      models.stream().forEach(model -> {
         transactionDtos.add(convertToDto(model));
      });
      return transactionDtos;
   }
   
   public static TransactionDto convertToDto(Transaction model){
      if (model == null){
         return null;
      }
      TransactionDto transactionDto = new TransactionDto();
      transactionDto.setCloseDate(model.getCloseDate());
      transactionDto.setPrice(model.getPrice());
      transactionDto.setTicket(model.getTicket().getId());
      return transactionDto;
   }

   public static TickerDto convertToDto(Ticker model){
      if (model == null){
         return null;
      }
      TickerDto ticketDto = new TickerDto();
      ticketDto.setId(model.getId());
      ticketDto.setName(model.getName());
      ticketDto.setTransactions(convertToTransactionDtos(model.getTransactions()));
      return ticketDto;
   }
}
