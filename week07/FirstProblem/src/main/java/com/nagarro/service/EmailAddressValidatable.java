package com.nagarro.service;

import com.nagarro.model.EmailAddressField;

public interface EmailAddressValidatable {
    boolean isEmailAddress(EmailAddressField emailAddressField);
}
