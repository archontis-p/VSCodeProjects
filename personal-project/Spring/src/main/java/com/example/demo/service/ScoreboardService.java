package com.example.demo.service;

import com.example.demo.dto.CreatePokemonRequest;
import com.example.demo.dto.CreateScoreboardRequest;
import com.example.demo.dto.UpdatePokemonRequest;
import com.example.demo.exception.PokemonNotFoundException;
import com.example.demo.model.Pokemon;
import com.example.demo.model.Scoreboard;
import com.example.demo.repository.PokemonDao;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.repository.ScoreboardDao;
import com.example.demo.repository.ScoreboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScoreboardService {

    private final ScoreboardRepository scoreboardRepository;
    private final ScoreboardConvertor scoreboardConvertor;

    public ScoreboardService(ScoreboardRepository scoreboardRepository,
                             ScoreboardConvertor scoreboardConvertor){
        this.scoreboardRepository = scoreboardRepository;
        this.scoreboardConvertor = scoreboardConvertor;
    }

    public List<Scoreboard> getAllScores(){
        return scoreboardRepository.findAll().stream()
                .map(scoreboardConvertor :: fromDao)
                .toList();
    }

    public Scoreboard getScoreById(int id){
        Optional<ScoreboardDao> scoreFound = scoreboardRepository.findById(id);

        if(scoreFound.isPresent()){
            ScoreboardDao score = scoreFound.get();
            return scoreboardConvertor.fromDao(score);
        }
        else{
            return null;
        }

    }

    public Scoreboard createScore(CreateScoreboardRequest request){
        ScoreboardDao scoreboardDao = scoreboardConvertor.fromCreateRequest(request);
        ScoreboardDao saved = scoreboardRepository.save(scoreboardDao);
        return scoreboardConvertor.fromDao(saved);
    }






}
