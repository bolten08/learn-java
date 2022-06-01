package com.learn.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${upload.dir}")
    private String uploadDir;

    @Value("${app.host}")
    private String appHost;

    public String getAppHost() {
        return appHost;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public String getImagePath() {
        return appHost + "/static/";
    }
}
