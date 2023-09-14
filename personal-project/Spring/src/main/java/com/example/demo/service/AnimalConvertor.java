package com.example.demo.service;

        import com.example.demo.model.Animal;
        import com.example.demo.repository.AnimalDao;
        import com.example.demo.repository.AnimalDao;
        import java.util.Random;
        import org.springframework.stereotype.Component;

@Component
public class AnimalConvertor {
    private final Random random = new Random();
    public Animal fromDao(AnimalDao animalDao) {
        return new Animal(
           animalDao.getId(),
           animalDao.getQuestion(),
           animalDao.getCorrect(),
           animalDao.getA(),
           animalDao.getB(),
           animalDao.getC(),
           animalDao.getD()
        );
    }

    public AnimalDao toDao(Animal animal) {
        return new AnimalDao(
                animal.getId(),
                animal.getQuestion(),
                animal.getCorrect(),
                animal.getA(),
                animal.getB(),
                animal.getC(),
                animal.getD()
        );
    }



}
