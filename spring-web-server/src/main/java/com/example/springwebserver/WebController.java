package com.example.springwebserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WebController {

    private final String id = "Web Server Node " + UUID.randomUUID();
    private final ApplicationContext context;

    public WebController(ApplicationContext context) {
        this.context = context;
    }

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

    @GetMapping(path = "/kill")
    public void kill() {
        SpringApplication.exit(context, () -> 0);
        System.exit(0);
    }
}
