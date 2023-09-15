package com.example.demo.service;

import com.example.demo.dto.CreatePokemonRequest;
import com.example.demo.dto.CreateScoreboardRequest;
import com.example.demo.dto.UpdatePokemonRequest;
import com.example.demo.model.Pokemon;
import com.example.demo.model.Scoreboard;
import com.example.demo.repository.PokemonDao;
import com.example.demo.repository.ScoreboardDao;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScoreboardConvertor {
    private final Random random = new Random();
    public Scoreboard fromDao(ScoreboardDao scoreboardDao) {
        return new Scoreboard(
                scoreboardDao.getId(),
                scoreboardDao.getCategory(),
                scoreboardDao.getScore(),
                scoreboardDao.getTimestamp()
        );
    }

    public ScoreboardDao toDao(Scoreboard scoreboard) {
        return new ScoreboardDao(
                scoreboard.getId(),
                scoreboard.getCategory(),
                scoreboard.getScore(),
                scoreboard.getTimestamp()
        );
    }

    public ScoreboardDao fromCreateRequest(CreateScoreboardRequest scoreboard){
        return new ScoreboardDao(
                scoreboard.getId(),
                scoreboard.getCategory(),
                scoreboard.getScore(),
                scoreboard.getTimestamp()
        );
    }



}
