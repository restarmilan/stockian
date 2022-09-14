package com.stockian.stockian.repository;

import com.stockian.stockian.constants.enums.UserStatus;
import com.stockian.stockian.entity.StockianUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<StockianUser, Long> {

  StockianUser findStockianUserByUserName(String userName);

  List<StockianUser> findStockianUsersByStatus(UserStatus status);
}
