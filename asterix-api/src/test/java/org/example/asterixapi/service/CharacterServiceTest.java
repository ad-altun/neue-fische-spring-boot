package org.example.asterixapi.service;

import org.example.asterixapi.model.Character;
import org.example.asterixapi.repository.CharacterRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CharacterServiceTest {

    private final CharacterRepository mockRepository
            = mock(CharacterRepository.class);

    @Test
    void findAllCharacters_shouldReturnAllCharacters_whenCalled() {
        // given
        Character character1 = new Character(1L,"asterix-1", 11, "warrior");
        Character character2 = new Character(2L,"asterix-2", 22, "Smith");

        List<Character> characters = new ArrayList<>(List.of(character1, character2));

        CharacterService characterService = new CharacterService(mockRepository);

        when(mockRepository.findAll()).thenReturn(characters);

        // when
        List<Character> actual = characterService.findAllCharacters();

        // then
        assertEquals(characters,actual);
    }
}