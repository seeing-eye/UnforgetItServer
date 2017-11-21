package org.jasey.unforgetit.server.service;

import org.jasey.unforgetit.server.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> getAll();
    Mono<User> save(User user);
    Flux<User> getByName(final String lastName);
}
