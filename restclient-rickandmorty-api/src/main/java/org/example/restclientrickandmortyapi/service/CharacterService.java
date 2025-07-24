package org.example.restclientrickandmortyapi.service;

import org.example.restclientrickandmortyapi.model.CharacterModel;
import org.example.restclientrickandmortyapi.model.CharacterResults;
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
}
