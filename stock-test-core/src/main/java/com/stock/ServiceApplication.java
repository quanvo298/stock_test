package com.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({ "com.stock.service" })
@EnableAutoConfiguration()
@EnableConfigurationProperties({ })
public class ServiceApplication {

   public static void main(final String[] args) {
      SpringApplication.run(ServiceApplication.class, args);
   }
}
