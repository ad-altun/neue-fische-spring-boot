package org.example.asterixapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "characters", schema = "practice")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String profession;
}
