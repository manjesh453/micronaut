package com.estore.users;

import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactorCrudRepository<User, Integer> {
    Mono<User> getByUsername(String username);
}
