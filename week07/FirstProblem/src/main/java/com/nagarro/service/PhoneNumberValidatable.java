package com.nagarro.service;

import com.nagarro.model.PhoneNumberField;

public interface PhoneNumberValidatable {
    boolean isPhoneNumber(PhoneNumberField phoneNumber);
}
