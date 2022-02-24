package com.nagarro.service;

import com.nagarro.model.PasswordField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator extends FieldValidator implements PasswordValidatable {

    private final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]\\^_`{|}~])[A-Za-z!\"#$%&'()*+,-./:;<=>?@\\[\\]\\^_`{|}~]{10,}";

    {
        this.regex = passwordRegex;
    }

    public PasswordValidator() {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isPassword(PasswordField password) {
        Matcher passwordMatcher = pattern.matcher(password.getValue());
        return passwordMatcher.matches();
    }
}
