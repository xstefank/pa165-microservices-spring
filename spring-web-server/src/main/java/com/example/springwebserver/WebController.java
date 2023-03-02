package com.example.springwebserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class WebController {

    private final String id = "Web Server Node " + UUID.randomUUID();

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping(path = "/whereami")
    public String whereami() {
        return restTemplate.getForObject("http://ip-api.com/json", String.class);
    }

    @GetMapping(path = "/whoami")
    public String whoami() {
        return "Id: " + id;
    }
}
