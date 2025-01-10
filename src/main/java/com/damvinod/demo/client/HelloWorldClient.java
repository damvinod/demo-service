package com.damvinod.demo.client;

import com.damvinod.demo.config.DemoProperties;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Service
public class HelloWorldClient {

    private WebClient webClient;
    private final DemoProperties demoProperties;

    HelloWorldClient(WebClient.Builder builder, HttpClient httpClient, DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
        this.webClient = builder.clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    public String getHelloResponse() {
        return webClient
                .get()
                .uri(demoProperties.host() + demoProperties.getHelloResponse())
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(10))
                .block();
    }

    public String getHelloResponseV1() {
        return webClient
                .get()
                .uri(demoProperties.hostV1() + demoProperties.getHelloResponse())
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(10))
                .block();
    }
}
