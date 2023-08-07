package com.example.testtestservicefour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class TesttestservicefourApplication {

    Logger logger = LoggerFactory.getLogger(TesttestservicefourApplication.class);

    @Autowired
    Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(TesttestservicefourApplication.class, args);
    }

    @GetMapping("/")
    public ResponseEntity<String> greet()
    {
        logger.info("greeting was sent");
        return new ResponseEntity<>("hello from test service four", HttpStatus.OK);

    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

}
