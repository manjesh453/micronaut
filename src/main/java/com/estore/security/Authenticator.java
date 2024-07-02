package com.estore.security;

import com.estore.users.UserRepo;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.security.authentication.AuthenticationFailureReason;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.ReactiveAuthenticationProvider;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Singleton
public class Authenticator implements ReactiveAuthenticationProvider {

    private final UserRepo userRepository;

    public Authenticator(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public @NonNull Publisher<AuthenticationResponse> authenticate(Object requestContext, @NonNull AuthenticationRequest authenticationRequest) {
        return userRepository.getByUsername(authenticationRequest.getIdentity().toString())
                .filter(user -> user.getPassword().equals(authenticationRequest.getSecret().toString()))
                .map(user -> AuthenticationResponse.success(user.getUsername(), Collections.emptyList()))
                .switchIfEmpty(Mono.just(AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)));

    }
}
