package com.damvinod.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello.world")
public record DemoProperties(String host, String hostV1, String getHelloResponse) {
}
