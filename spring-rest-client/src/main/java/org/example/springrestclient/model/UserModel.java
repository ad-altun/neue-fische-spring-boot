package org.example.springrestclient.model;

public record UserModel(
        String id,
        String email,
        String first_name,
        String last_name,
        String avatar) {
}
