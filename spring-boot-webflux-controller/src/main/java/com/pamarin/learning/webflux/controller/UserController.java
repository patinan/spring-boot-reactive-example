/*
 * Copyright 2017-2019 Pamarin.com
 */
package com.pamarin.learning.webflux.controller;

import com.pamarin.learning.webflux.model.User;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author jitta
 */
@RestController
public class UserController {

    @GetMapping("/users")
    public Mono<List<User>> findAll() {
        return Mono.just(Arrays.asList(
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .username("jittagornp")
                        .password("test")
                        .email("jittagornp@gmail.com")
                        .build(),
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .username("test")
                        .password("password")
                        .email("test@example.com")
                        .build()
        ));
    }

    @GetMapping("/users/{id}")
    public Mono<User> findById(@PathVariable("id") String id) {
        return Mono.just(
                User.builder()
                        .id(id)
                        .username("jittagornp")
                        .password("test")
                        .email("jittagornp@gmail.com")
                        .build()
        );
    }

    @GetMapping("/me")
    public Mono<User> getUser() {
        return Mono.just(
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .username("jittagornp")
                        .password("test")
                        .email("jittagornp@gmail.com")
                        .build()
        );
    }
}