package com.animal.shelter.persistence.entity;

import com.animal.shelter.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "animals")
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
public class AnimalEntity  extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal", nullable = false)
    private Integer idAnimal;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "age_in_months", nullable = false)
    private Integer ageMonths;

    @Column(nullable = false, columnDefinition = "Decimal(5,3)")
    private Double weight;

    @Column(nullable = false, length = 150)
    private String breed;

    @Column(nullable = false, length = 150)
    private String type;

}
