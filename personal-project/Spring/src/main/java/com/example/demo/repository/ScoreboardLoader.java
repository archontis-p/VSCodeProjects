package com.example.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

@Component
public class ScoreboardLoader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ScoreboardLoader.class);
    private static final String SCOREBOARD_JSON_FILE_LOCATION = "classpath:scoreboard.json";
    private final ScoreboardRepository scoreboardRepository;

    public ScoreboardLoader(ScoreboardRepository scoreboardRepository) {
        this.scoreboardRepository = scoreboardRepository;
    }

    @Override
    public void run(String... args) throws IOException {
        File file = ResourceUtils.getFile(SCOREBOARD_JSON_FILE_LOCATION);
        String content = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
        List<ScoreboardDao> scores = mapper.readValue(content, new TypeReference<>() {
        });

        scores.forEach(scoreboardRepository::save);
        LOG.info("Attempted to save {} scoreboard objects in the repository", scores.size());

        Collection<ScoreboardDao> saved = scoreboardRepository.findAll();
        LOG.info("{} were actually saved:", saved.size());
    }


}
