package com.stockian.stockian;

import com.stockian.stockian.service.PropertyLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories
public class StockianApplication {

  public static void main(String[] args) {

    SpringApplication.run(StockianApplication.class, args);
  }

}
