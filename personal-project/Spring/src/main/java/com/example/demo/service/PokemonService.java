package com.example.demo.service;

import com.example.demo.dto.CreatePokemonRequest;
import com.example.demo.dto.UpdatePokemonRequest;
import com.example.demo.repository.PokemonDao;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.exception.PokemonNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pokemon;
import java.util.Optional;

import java.util.List;
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonConvertor pokemonConvertor;

    public PokemonService(PokemonRepository pokemonRepository,
                          PokemonConvertor pokemonConvertor){
        this.pokemonRepository = pokemonRepository;
        this.pokemonConvertor = pokemonConvertor;
    }

    public List<Pokemon> getAllPokemon(){
        return pokemonRepository.findAll().stream()
                .map(pokemonConvertor :: fromDao)
                .toList();
    }

    public Pokemon getPokemonById(int id){
        Optional<PokemonDao> pokemonFound = pokemonRepository.findById(id);

        if(pokemonFound.isPresent()){
            PokemonDao pokemon = pokemonFound.get();
            return pokemonConvertor.fromDao(pokemon);
        }
        else{
            throw new PokemonNotFoundException(id);
        }

    }

    public Pokemon createPokemon(CreatePokemonRequest request){
        PokemonDao pokemonDao = pokemonConvertor.fromCreateRequest(request);
        PokemonDao saved = pokemonRepository.save(pokemonDao);
        return pokemonConvertor.fromDao(saved);
    }


    public Pokemon updatePokemon(int id, UpdatePokemonRequest request){
        Optional<PokemonDao> pokemonFound = pokemonRepository.findById(id);

        if(pokemonFound.isPresent()){
            PokemonDao pokemonDao = pokemonConvertor.fromUpdateRequest(id, request);
            PokemonDao saved = pokemonRepository.save(pokemonDao);
            return pokemonConvertor.fromDao(saved);
        }
        else{
            throw new PokemonNotFoundException(id);
        }

    }

    public void deletePokemon(int id){
        Optional<PokemonDao> pokemonFound = pokemonRepository.findById(id);

        if(pokemonFound.isPresent()){
            pokemonRepository.deleteById(id);
        }
        else{
            throw new PokemonNotFoundException(id);
        }



    }

}
