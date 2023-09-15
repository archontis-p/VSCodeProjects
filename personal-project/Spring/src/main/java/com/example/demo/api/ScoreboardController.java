package com.example.demo.api;


import com.example.demo.dto.CreateScoreboardRequest;
import com.example.demo.model.Scoreboard;
import com.example.demo.service.ScoreboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping(value = "/scoreboard", produces = APPLICATION_JSON_VALUE)
public class ScoreboardController {
    private final ScoreboardService scoreboardService;

    public ScoreboardController(ScoreboardService scoreboardService){
        this.scoreboardService = scoreboardService;
    }
    @GetMapping("")
    public List<Scoreboard> getAllScores(){
        return scoreboardService.getAllScores();
    }

    @GetMapping("/{id}")
    public Scoreboard getScoreById(@PathVariable("id") int id){
        return scoreboardService.getScoreById(id);
    }


    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Scoreboard createScore(@RequestBody CreateScoreboardRequest request){
        return scoreboardService.createScore(request);
    }


}
