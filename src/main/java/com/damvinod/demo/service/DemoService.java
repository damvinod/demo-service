package com.damvinod.demo.service;

import com.damvinod.demo.client.DockerExampleClient;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private DockerExampleClient dockerExampleClient;

    DemoService(DockerExampleClient dockerExampleClient) {
        this.dockerExampleClient = dockerExampleClient;
    }

    public String getHelloResponse() {
        return dockerExampleClient.getHelloResponse();
    }
}
