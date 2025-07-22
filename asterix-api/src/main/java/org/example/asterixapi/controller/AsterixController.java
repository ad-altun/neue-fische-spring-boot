package org.example.asterixapi.controller;

import org.example.asterixapi.model.Character;
import org.example.asterixapi.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
public class AsterixController {

    private final CharacterService characterService;

    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public Character findCharacterById(@PathVariable Long id) {
        return characterService.findCharacterById(id).orElse(null);
    }

    @GetMapping
    public List<Character> getCharacters() {
        return characterService.findAllCharacters();
    }

    @PostMapping
    public List<Character> addCharacters(@RequestBody List<Character> characters) {
        return characterService.addCharacters(characters);
    }

}
