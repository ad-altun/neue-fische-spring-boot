package org.example.asterixapi.service;

import org.example.asterixapi.model.Character;
import org.example.asterixapi.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> findAllCharacters() {
        return characterRepository.findAll();
    }

    public Optional<Character> findCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    public List<Character> addCharacters(List<Character> characters) {
        return characterRepository.saveAll(characters);
    }
}
