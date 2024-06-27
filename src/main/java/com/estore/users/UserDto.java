package com.estore.users;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record UserDto(String name,
                      String email,
                      String contact,
                      String password) {

}
