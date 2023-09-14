package com.example.demo.service;

import com.example.demo.dto.CreatePokemonRequest;
import com.example.demo.dto.UpdatePokemonRequest;
import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonDao;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class PokemonConvertor {
    private final Random random = new Random();
    public Pokemon fromDao(PokemonDao pokemonDao) {
        return new Pokemon(
            pokemonDao.getId(),
            pokemonDao.getName(),
            pokemonDao.getHeight(),
            pokemonDao.getWeight(),
            pokemonDao.getTypes(),
            pokemonDao.getSprite()
        );
    }

    public PokemonDao toDao(Pokemon pokemon) {
        return new PokemonDao(
            pokemon.getId(),
            pokemon.getName(),
            pokemon.getHeight(),
            pokemon.getWeight(),
            pokemon.getTypes(),
            pokemon.getSprite()
        );
    }

    public PokemonDao fromCreateRequest(CreatePokemonRequest pokemon){
        int id = 100 + random.nextInt(1000000);
        return new PokemonDao(
                id,
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getTypes(),
                pokemon.getSprite()
        );
    }

    public PokemonDao fromUpdateRequest(int id, UpdatePokemonRequest pokemon){
        return new PokemonDao(
                id,
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getTypes(),
                pokemon.getSprite()
        );
    }

}
