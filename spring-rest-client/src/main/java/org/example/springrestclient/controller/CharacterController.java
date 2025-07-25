package org.example.springrestclient.controller;

import org.example.springrestclient.model.CharacterModel;
import org.example.springrestclient.service.CharacterService;
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

    @GetMapping("/species-statistic")
    public String getStatistics(@RequestParam String species) {
        return characterService.getStatistics(species);
    }
}
