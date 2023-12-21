package com.animal.shelter.web.controller;

import com.animal.shelter.persistence.entity.AdoptionEntity;
import com.animal.shelter.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adoptions")
public class AdoptionController {

    private final AdoptionService adoptionService;

    @Autowired
    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public ResponseEntity<Page<AdoptionEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "8") int size) {
        return ResponseEntity.ok(this.adoptionService.getAll(page, size));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<AdoptionEntity>> getAdoptionsByUser(@PathVariable String username) {
        List<AdoptionEntity> adoptions = adoptionService.getAdoptionsByUser(username);
        return adoptions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(adoptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionEntity> getAdoptionById(@PathVariable Integer id) {
        Optional<AdoptionEntity> adoption = adoptionService.getAdoptionById(id);
        return adoption.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<AdoptionEntity> saveAdoption(@RequestBody AdoptionEntity adoptionEntity) {
        AdoptionEntity savedAdoption = adoptionService.saveAdoption(adoptionEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdoption);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdoption(@PathVariable Integer id) {
        adoptionService.deleteAdoption(id);
        return ResponseEntity.noContent().build();
    }

}
