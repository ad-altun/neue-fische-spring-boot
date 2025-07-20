package org.example.messageexercise.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "messages_list", schema = "practice")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String message;
}
