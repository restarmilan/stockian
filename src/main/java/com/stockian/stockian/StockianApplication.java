package com.stockian.stockian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StockianApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockianApplication.class, args);
  }

}
