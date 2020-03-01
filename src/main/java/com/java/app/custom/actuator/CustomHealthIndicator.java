package com.java.app.custom.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return checkInternet()
                ? Health.up().withDetail("Success code", "Active internet connection").build()
                : Health.down().withDetail("Error code", "In Active internet connection").build();
    }

    private boolean checkInternet() {
        boolean isInternetUp;

        try {
            URL url = new URL("https://www.google.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            isInternetUp = true;
        } catch (Exception e) {
            isInternetUp = false;
        }

        return isInternetUp;
    }
}
