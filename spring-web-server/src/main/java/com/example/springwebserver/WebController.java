package com.example.springwebserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WebController {

    private final String id = "Web Server Node " + UUID.randomUUID();

    @GetMapping(path = "/whereami")
    public Mono<String> whereami() {
        return WebClient.create()
            .get()
            .uri("http://ip-api.com/json")
            .retrieve()
            .bodyToMono(String.class);
    }

    @GetMapping(path = "/whoami")
    public String whoami() {
        return "Id: " + id;
    }
}
