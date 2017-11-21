package org.jasey.unforgetit.server.controller;

import org.jasey.unforgetit.server.domain.User;
import org.jasey.unforgetit.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<User> post(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public Flux<User> get() {
        return userService.getAll();
    }

    @GetMapping("{name}")
    public Flux<User> getByName(@PathVariable(name = "name") String name) {
        return userService.getByName(name);
    }
}
