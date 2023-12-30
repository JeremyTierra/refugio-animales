package com.animal.shelter.service;

import com.animal.shelter.persistence.entity.AnimalEntity;
import com.animal.shelter.persistence.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Page<AnimalEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return animalRepository.findAll(pageRequest);
    }

    public Page<AnimalEntity> getAllByBreed(String breed, int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return animalRepository.findByBreed(breed, pageRequest);
    }

    public Page<AnimalEntity> getAllByType(String type, int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return animalRepository.findByType(type, pageRequest);
    }

    public Page<AnimalEntity> getAllByAgeRange(int minAge, int maxAge, int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return animalRepository.findByAgeMonthsBetween(minAge, maxAge, pageRequest);
    }

    public Page<AnimalEntity> getAllByAge(int age, int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return animalRepository.findByAgeMonths(age, pageRequest);
    }

    public boolean exists(int idAnimal) {
        return this.animalRepository.existsById(idAnimal);
    }

    public AnimalEntity save(AnimalEntity animal) {
        return this.animalRepository.save(animal);
    }
    public void deleteById(int id) {
        this.animalRepository.deleteById(id);
    }
}
