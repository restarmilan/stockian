package com.stockian.stockian.controller;

import lombok.Getter;
import lombok.Setter;

public class LoginForm {

  @Getter
  private String userName;

  @Getter
  private String password;

  @Getter
  @Setter
  private boolean isSuccessful = false;
}
