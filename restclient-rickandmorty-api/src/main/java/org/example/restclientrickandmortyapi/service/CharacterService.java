package org.example.restclientrickandmortyapi.service;

import org.example.restclientrickandmortyapi.model.CharacterModel;
import org.example.restclientrickandmortyapi.model.CharacterResults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CharacterService {

    private final RestClient restClient;

    public CharacterService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<CharacterModel> getAllCharacters() {
        List<CharacterModel> characters =
                restClient.get().uri("/character")
                        .retrieve()
                        .body(CharacterResults.class)
                        .results();

        return  characters;
    }

    public CharacterModel getCharacterById(Integer id) {

        CharacterModel character =
                restClient.get().uri("/character/{id}", id)
                        .retrieve()
                        .body(CharacterModel.class);

        return character;

        // Alternative
        // -------------------------
        // ResponseEntity<CharacterModel> character =
        //        restClient.get().uri("/character/{id}", id)
        //                .retrieve()
        //                .toEntity(CharacterModel.class);

        // return character.getBody();
    }

    public List<CharacterModel> filterCharactersByStatus(String status) {

        List<CharacterModel> characters =
                restClient.get()
                        .uri("/character?status={status}", status)
                        .retrieve()
                        .body(CharacterResults.class)
                        .results();

        return characters;
    }


}
