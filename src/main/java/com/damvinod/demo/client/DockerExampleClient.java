package com.damvinod.demo.client;

import com.damvinod.demo.config.DemoProperties;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Service
public class DockerExampleClient {

    private WebClient webClient;
    private final DemoProperties demoProperties;

    DockerExampleClient(WebClient.Builder builder, HttpClient httpClient, DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
        this.webClient = builder.clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(demoProperties.host())
                .build();
    }

    public String getHelloResponse() {
        return webClient
                .get()
                .uri(demoProperties.getHelloResponse())
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(10))
                .block();
    }
}
