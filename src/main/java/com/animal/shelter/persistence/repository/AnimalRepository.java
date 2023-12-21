package com.animal.shelter.persistence.repository;

import com.animal.shelter.persistence.entity.AnimalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
    Page<AnimalEntity> findByBreed(String breed, Pageable pageable);
    Page<AnimalEntity> findByType(String type, Pageable pageable);
    Page<AnimalEntity> findByAgeMonthsBetween(int minAge, int maxAge, Pageable pageable);
    Page<AnimalEntity> findByAgeMonths(int age, Pageable pageable);


}
