package com.damvinod.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "docker.example")
public record DemoProperties(String host, String getHelloResponse) {
}
