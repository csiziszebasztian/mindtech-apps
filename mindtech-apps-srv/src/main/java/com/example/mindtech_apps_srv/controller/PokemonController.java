package com.example.mindtech_apps_srv.controller;

import com.example.mindtech_apps_srv.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/")
    public ResponseEntity<?> getPokemons() {
        return ResponseEntity.ok(pokemonService.getPokemons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPokemonDetails(@PathVariable BigInteger id) {
        return ResponseEntity.ok(pokemonService.getPokemonDetails(id));
    }

    @PostMapping("/catch")
    public ResponseEntity<Void> catchPokemon(@RequestParam BigInteger id) {
        pokemonService.catchPokemon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/release")
    public ResponseEntity<Void> releasePokemon(@RequestParam BigInteger id) {
        pokemonService.releasePokemon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}