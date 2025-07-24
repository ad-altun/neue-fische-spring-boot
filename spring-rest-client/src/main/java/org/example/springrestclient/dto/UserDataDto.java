package org.example.springrestclient.dto;

public record UserDataDto (
        String id,
        String name,
        String job,
        String createdAt) {
}
