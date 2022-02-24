package com.nagarro.service;

import com.nagarro.model.EmailAddressField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressValidator extends FieldValidator implements EmailAddressValidatable {

    private final String emailAddressRegex = "^[^@]+@[^@.]+.[a-zA-Z]{2,3}$";

    {
        this.regex = emailAddressRegex;
    }

    public EmailAddressValidator() {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isEmailAddress(EmailAddressField emailAddressField) {
        Matcher emailAddressMatcher = pattern.matcher(emailAddressField.getValue());
        return emailAddressMatcher.matches();
    }
}
