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
public class AnimalLoader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(AnimalLoader.class);
    private static final String ANIMALS_JSON_FILE_LOCATION = "classpath:animals.json";
    private final AnimalRepository animalRepository;

    public AnimalLoader(AnimalRepository animalsRepository) {
        this.animalRepository = animalsRepository;
    }

    @Override
    public void run(String... args) throws IOException {
        File file = ResourceUtils.getFile(ANIMALS_JSON_FILE_LOCATION);
        String content = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
        List<AnimalDao> animals = mapper.readValue(content, new TypeReference<>() {
        });

        animals.forEach(animalRepository::save);
        LOG.info("Attempted to save {} animal questions in the repository", animals.size());

        Collection<AnimalDao> saved = animalRepository.findAll();
        LOG.info("{} were actually saved:", saved.size());
    }
}
