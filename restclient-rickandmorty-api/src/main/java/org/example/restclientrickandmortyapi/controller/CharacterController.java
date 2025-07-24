package org.example.restclientrickandmortyapi.controller;

import org.example.restclientrickandmortyapi.model.CharacterModel;
import org.example.restclientrickandmortyapi.service.CharacterService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("character/")
    public List<CharacterModel> filterCharactersByStatus(@RequestParam String status) {
        return characterService.filterCharactersByStatus(status);
    }
}
