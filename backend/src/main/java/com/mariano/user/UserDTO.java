package com.mariano.user;

public record UserDTO (
        Integer id,
        String name,
        String email,
        Gender gender,
        Integer age,
        String username
){
    
}
