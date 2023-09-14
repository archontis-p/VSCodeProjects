package com.example.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class PokemonLoader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(PokemonLoader.class);
    private static final String POKEMON_JSON_FILE_LOCATION = "classpath:pokemon.json";
    private final PokemonRepository pokemonRepository;

    public PokemonLoader(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void run(String... args) throws IOException {
        File file = ResourceUtils.getFile(POKEMON_JSON_FILE_LOCATION);
        String content = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
        List<PokemonDao> pokemon = mapper.readValue(content, new TypeReference<>() {
        });

        pokemon.forEach(pokemonRepository::save);
        LOG.info("Attempted to save {} Pokemon in the repository", pokemon.size());

        Collection<PokemonDao> saved = pokemonRepository.findAll();
        LOG.info("{} were actually saved:", saved.size());
        LOG.info("{}", saved);
    }
}
