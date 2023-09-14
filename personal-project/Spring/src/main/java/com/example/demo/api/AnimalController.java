package com.example.demo.api;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping(value = "/animals", produces = APPLICATION_JSON_VALUE)
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("")
    public List<Animal> getAllAnimals(){ return animalService.getAllAnimals();
    }


    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") int id){
        return animalService.getAnimalById(id);
    }


}
