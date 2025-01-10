package com.damvinod.demo.service;

import com.damvinod.demo.client.HelloWorldClient;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private HelloWorldClient helloWorldClient;

    DemoService(HelloWorldClient helloWorldClient) {
        this.helloWorldClient = helloWorldClient;
    }

    public String getHelloResponse() {
        return helloWorldClient.getHelloResponse();
    }

    public String getHelloResponseV1() {
        return helloWorldClient.getHelloResponseV1();
    }
}
