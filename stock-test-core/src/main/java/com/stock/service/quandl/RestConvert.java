package com.stock.service.quandl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.stock.model.Ticker;
import com.stock.model.Transaction;

public class RestConvert {
   private static final String REST_SHORTDATEFORMAT = "yyyy-MM-dd";
   private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(REST_SHORTDATEFORMAT);

   public static String convert(Date date) {
      return SIMPLE_DATE_FORMAT.format(date);
   }

   public static Date convert(String date) throws ParseException {
      return SIMPLE_DATE_FORMAT.parse(date);
   }

   public static Ticker convertTicket(JSONObject jsonObject) throws ParseException {
      JSONObject dataset = jsonObject.getJSONObject("dataset");
      Ticker ticket = new Ticker();
      ticket.setId(dataset.getLong("id"));
      ticket.setName(dataset.getString("dataset_code"));
      JSONArray jsonArray = dataset.getJSONArray("data");
      for (int index = 0; index < jsonArray.size(); index++) {
         ticket.add(converTransaction(jsonArray.getJSONArray(index)));
      }
      return ticket;
   }

   public static Transaction converTransaction(JSONArray jsonArray) throws ParseException {
      Transaction transaction = new Transaction();
      transaction.setCloseDate(convert(jsonArray.getString(0)));
      transaction.setPrice(jsonArray.getDouble(1));
      return transaction;
   }
}
