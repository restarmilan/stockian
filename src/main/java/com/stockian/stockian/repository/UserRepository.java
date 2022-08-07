package com.stockian.stockian.repository;

import com.stockian.stockian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
}
