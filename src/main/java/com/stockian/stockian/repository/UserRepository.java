package com.stockian.stockian.repository;

import com.stockian.stockian.entity.StockianUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<StockianUser, Long> {

  StockianUser findStockianUserByUserName(String userName);
}
