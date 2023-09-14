package com.example.demo.exception;


import lombok.EqualsAndHashCode;
import lombok.Value;


@Value
public class PokemonNotFoundException extends RuntimeException {

    int pokemonId;

}

//
//    public PokemonNotFoundException(int pokemonId){
//        this.pokemonId = pokemonId;
//    }
//
//    public int getPokemonId(){
//        return pokemonId;
//    }
////





