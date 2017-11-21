package org.jasey.unforgetit.server.service;


import org.jasey.unforgetit.server.domain.User;
import org.jasey.unforgetit.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<User> getAll() {
        return userRepository.findAll().log().doOnNext(u -> {
            try {
                System.out.println(u + " time " + Instant.now());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Flux<User> getByName(String name) {
        return userRepository.findAll()
                .filter(u -> u.getName().equals(name));
    }
}
