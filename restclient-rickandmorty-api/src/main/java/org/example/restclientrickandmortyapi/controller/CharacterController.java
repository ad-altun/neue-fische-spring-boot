package org.example.restclientrickandmortyapi.controller;

import org.example.restclientrickandmortyapi.model.CharacterModel;
import org.example.restclientrickandmortyapi.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/character")
    public List<CharacterModel> getCharacters () {
        return characterService.getAllCharacters();
    }

    @GetMapping("/character/{id}")
    public CharacterModel getCharacterById(@PathVariable Integer id) {
        return characterService.getCharacterById(id);
    }
}
