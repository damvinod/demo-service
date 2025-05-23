package com.damvinod.demo.controller;

import com.damvinod.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
public class DemoController {

    private DemoService demoService;

    DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(path = "/hello")
    public ResponseEntity<String> helloWorld() {
        log.info("Demo Service controller invoked for hello.");
        return status(HttpStatus.OK).body(demoService.getHelloResponse());
    }

    @GetMapping(path = "/v1/hello")
    public ResponseEntity<String> helloWorldV1() {
        log.info("Demo Service controller invoked for hello v1.");
        return status(HttpStatus.OK).body(demoService.getHelloResponseV1());
    }
}
