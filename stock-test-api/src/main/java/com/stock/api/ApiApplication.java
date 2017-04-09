package com.stock.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.stock.ServiceApplication;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import({ ServiceApplication.class })
public class ApiApplication {

   public static void main(final String[] args) {
      SpringApplication.run(ApiApplication.class, args);
   }
}
