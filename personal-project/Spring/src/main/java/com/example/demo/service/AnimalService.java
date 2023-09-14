package com.example.demo.service;

import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.AnimalDao;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.service.AnimalConvertor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalConvertor animalConvertor;

    public AnimalService(AnimalRepository animalRepository,
                         AnimalConvertor animalConvertor){
        this.animalRepository = animalRepository;
        this.animalConvertor = animalConvertor;
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll().stream()
                .map(animalConvertor :: fromDao)
                .toList();
    }

    public Animal getAnimalById(int id){
        AnimalDao found = animalRepository.findById(id);
        return animalConvertor.fromDao(found);

    }


}
