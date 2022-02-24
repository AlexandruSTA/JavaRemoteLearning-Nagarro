package com.nagarro.service;

import com.nagarro.model.PhoneNumberField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator extends FieldValidator implements PhoneNumberValidatable {
    private final String phoneNumberRegex = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";

    {
        this.regex = phoneNumberRegex;
    }

    public PhoneNumberValidator() {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isPhoneNumber(PhoneNumberField phoneNumber) {
        Matcher phoneNumberMatcher = pattern.matcher(phoneNumber.getValue());
        return phoneNumberMatcher.matches();
    }
}
