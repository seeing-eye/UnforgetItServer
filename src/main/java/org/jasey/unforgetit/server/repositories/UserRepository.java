package org.jasey.unforgetit.server.repositories;

import org.jasey.unforgetit.server.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<User> findByName(Mono<String> name);

}
