package com.spring.demo.vehicle_registration_system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BundleMessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return messageSource.getMessage(
                key,
                null,
                Locale.getDefault()
        );
    }
}