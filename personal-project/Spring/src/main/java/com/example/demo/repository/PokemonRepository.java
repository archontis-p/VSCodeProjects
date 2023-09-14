package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepository {

    private final Map<Integer, PokemonDao> pokemon = new HashMap<>();
    public Collection<PokemonDao> findAll() {
        return pokemon.values();
    }

    public Optional<PokemonDao> findById(int id) {
        return Optional.ofNullable(pokemon.get(id));
    }

    public PokemonDao save(PokemonDao toSave) {
        pokemon.put(toSave.id, toSave);
        return toSave;
    }

    public void deleteById(int id) {
        pokemon.remove(id);
    }
}
