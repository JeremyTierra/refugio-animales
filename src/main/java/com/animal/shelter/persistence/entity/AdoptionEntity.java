package com.animal.shelter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDate;

@Entity
@Table(name = "adoptions")
@Getter
@Setter
@NoArgsConstructor
public class AdoptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "adoption_date")
    @CreatedBy
    private LocalDate adoptionDate;

    @Column(name = "animal_id")
    private Integer animalId;

    @Column(name = "user_name")
    private String userName;


}
