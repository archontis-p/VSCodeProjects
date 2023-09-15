package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ScoreboardRepository {
    private final Map<Integer, ScoreboardDao> score = new HashMap<>();
    public Collection<ScoreboardDao> findAll() {
        return score.values();
    }

    public Optional<ScoreboardDao> findById(int id) {
        return Optional.ofNullable(score.get(id));
    }

    public ScoreboardDao save(ScoreboardDao toSave) {
        score.put(toSave.id, toSave);
        return toSave;
    }

    public void deleteById(int id) {
        score.remove(id);
    }




}
