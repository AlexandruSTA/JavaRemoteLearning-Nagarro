package com.nagarro.service;

import com.nagarro.model.PasswordField;

public interface PasswordValidatable {
    boolean isPassword(PasswordField password);
}
