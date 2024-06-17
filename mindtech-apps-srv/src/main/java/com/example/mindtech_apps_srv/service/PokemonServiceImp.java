package com.example.mindtech_apps_srv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class PokemonServiceImp implements PokemonService {

    private final RestTemplate restTemplate;

    @Override
    public Object getPokemons() {
        Object pokemons = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon", Object.class);
        return pokemons;
    }

    @Override
    public Object getPokemonDetails(BigInteger id) {
        return null;
    }

    @Override
    public void catchPokemon(BigInteger id) {

    }

    @Override
    public void releasePokemon(BigInteger id) {

    }
}
