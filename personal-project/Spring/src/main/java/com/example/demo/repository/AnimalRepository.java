package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalRepository {

    private final Map<Integer, AnimalDao> animal = new HashMap<>();
    public Collection<AnimalDao> findAll() {
        return animal.values();
    }

    public AnimalDao findById(int id) {
        return animal.get(id);
    }

    public AnimalDao save(AnimalDao toSave) {
        animal.put(toSave.id, toSave);
        return toSave;
    }

    public void deleteById(int id) {
        animal.remove(id);
    }
}