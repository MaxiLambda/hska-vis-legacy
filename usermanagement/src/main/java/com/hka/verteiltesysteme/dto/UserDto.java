package com.hka.verteiltesysteme.dto;

import org.springframework.lang.NonNull;

public record UserDto(@NonNull String username,@NonNull String password, @NonNull String firstname,@NonNull String lastname) {
}
