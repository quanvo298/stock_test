package com.stock.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
   public static Date plusDate(Date startDate, int plusDays){
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(startDate);
      calendar.add(Calendar.DAY_OF_MONTH, plusDays);
      return calendar.getTime();
   }
   
   public static void main(String[] args) {
      System.out.println(new Date(System.currentTimeMillis()));
      System.out.println(plusDate(new Date(System.currentTimeMillis()),200));
   }
}
