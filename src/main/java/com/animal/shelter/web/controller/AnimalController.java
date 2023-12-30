package com.animal.shelter.web.controller;

import com.animal.shelter.persistence.entity.AnimalEntity;
import com.animal.shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;
@Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<Page<AnimalEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "12") int elements) {
        return ResponseEntity.ok(this.animalService.getAll(page, elements));
    }

    @GetMapping("/breed/{breed}")
    public ResponseEntity<Page<AnimalEntity>> getAllByBreed(
            @PathVariable String breed,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int elements) {
        return ResponseEntity.ok(animalService.getAllByBreed(breed, page, elements));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<Page<AnimalEntity>> getAllByType(
            @PathVariable String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int elements) {
        return ResponseEntity.ok(animalService.getAllByType(type, page, elements));
    }

    @GetMapping("/age-range/{minAge}/{maxAge}")
    public ResponseEntity<Page<AnimalEntity>> getAllByAgeRange(
            @PathVariable int minAge,
            @PathVariable int maxAge,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int elements) {
        return ResponseEntity.ok(animalService.getAllByAgeRange(minAge, maxAge, page, elements));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Page<AnimalEntity>> getAllByAge(
            @PathVariable int age,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int elements) {
        return ResponseEntity.ok(animalService.getAllByAge(age, page, elements));
    }



    @PostMapping
    public ResponseEntity<AnimalEntity> add(@RequestBody AnimalEntity animal) {
        if (animal.getIdAnimal()== null || !this.animalService.exists(animal.getIdAnimal())) {
            return ResponseEntity.ok(this.animalService.save(animal));
        }

        return ResponseEntity.badRequest().build();
    }


    @PutMapping
    public ResponseEntity<AnimalEntity> update(@RequestBody AnimalEntity animal) {
        if (animal.getIdAnimal() != null && this.animalService.exists(animal.getIdAnimal())) {
            return ResponseEntity.ok(this.animalService.save(animal));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (id != null && this.animalService.exists(id)) {
            this.animalService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
