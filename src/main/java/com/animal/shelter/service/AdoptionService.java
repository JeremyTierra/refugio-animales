package com.animal.shelter.service;

import com.animal.shelter.persistence.entity.AdoptionEntity;
import com.animal.shelter.persistence.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionService {
    private  AdoptionRepository adoptionRepository;

    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }


    public Page<AdoptionEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return adoptionRepository.findAll(pageRequest);
    }

    public Optional<AdoptionEntity> getAdoptionById(Integer id) {
        return adoptionRepository.findById(id);
    }

    public AdoptionEntity saveAdoption(AdoptionEntity adoptionEntity) {
        return adoptionRepository.save(adoptionEntity);
    }

    public void deleteAdoption(Integer id) {
        adoptionRepository.deleteById(id);
    }
    public List<AdoptionEntity> getAdoptionsByUser(String username) {
        return adoptionRepository.findAnimalsByUser(username);
    }

}
