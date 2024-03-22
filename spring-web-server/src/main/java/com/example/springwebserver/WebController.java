package com.example.springwebserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WebController {

    private final String id = "Web server node " + UUID.randomUUID();

    @GetMapping(path = "/whereami")
    public Mono<String> whereAmI() {
        return WebClient.create()
            .get().uri("http://ip-api.com/json")
            .retrieve().bodyToMono(String.class);
    }

    @GetMapping(path = "/whoami")
    public String whoAmI() {
        return id;
    }
}
