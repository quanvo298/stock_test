package com.stock.service.quandl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import com.stock.model.Ticker;

@Component
public class RestClient {
   private static final String BaseURL = "https://www.quandl.com/api/v3/datasets/WIKI/GE.json";

   public Ticker retreiveTransactions(Date startDate, Date endDate) throws ClientProtocolException, IOException, ParseException {
      StringBuilder stringBuilder = new StringBuilder(BaseURL);
      stringBuilder = stringBuilder.append("?").append("&column_index=4")
            .append("&start_date=" + RestConvert.convert(startDate))
            .append("&end_date=" + RestConvert.convert(endDate));
      String url = stringBuilder.toString();
      HttpClient httpClient = HttpClients.createDefault();
      final HttpGet httpGet = new HttpGet(url);
      final HttpResponse httpResponse = httpClient.execute(httpGet);
      JSONObject result = parseResult(httpResponse);
      return RestConvert.convertTicket(result);
   }

   public Ticker retreiveTransactions() throws ClientProtocolException, IOException, ParseException {
      StringBuilder stringBuilder = new StringBuilder(BaseURL);
      stringBuilder = stringBuilder.append("?").append("&column_index=4");
      String url = stringBuilder.toString();
      HttpClient httpClient = HttpClients.createDefault();
      final HttpGet httpGet = new HttpGet(url);
      final HttpResponse httpResponse = httpClient.execute(httpGet);
      JSONObject result = parseResult(httpResponse);
      return RestConvert.convertTicket(result);
   }

   
   private JSONObject parseResult(final HttpResponse httpResponse) throws IOException {
      final BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

      String inputLine;
      final StringBuffer response = new StringBuffer();

      while ((inputLine = reader.readLine()) != null) {
         response.append(inputLine);
      }
      reader.close();
      final String value = response.toString();
      return JSONObject.fromObject(value);
   }
}
