package com.mariano.user;

public record UserUpdateRequest(
        String name,
        String email,
        Integer age
) {
}