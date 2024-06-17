package com.example.mindtech_apps_srv.service;

import java.math.BigInteger;

public interface PokemonService {
    Object getPokemons();

    Object getPokemonDetails(BigInteger id);

    void catchPokemon(BigInteger id);

    void releasePokemon(BigInteger id);
}