package com.stockian.stockian.entity;

import com.stockian.stockian.constants.enums.UserStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "stockianUser")
@Table(name = "stockian_user")
public class StockianUser {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, unique = true)
  private String userName;

  private UserStatus status;

  @Column(nullable = false)
  private String password;
}
