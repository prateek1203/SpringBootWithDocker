package com.java.app.custom.annotations.impl;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationImpl {
    public boolean authorize(String token) {
        return true;
    }
}
