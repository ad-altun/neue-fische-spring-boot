package org.example.asterixapi.repository;

import org.example.asterixapi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    Character deleteCharacterById(Long id);
}
