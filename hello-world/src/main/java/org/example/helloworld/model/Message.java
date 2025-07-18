package org.example.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private final String id;
    private final String name;
    private final String message;
}
