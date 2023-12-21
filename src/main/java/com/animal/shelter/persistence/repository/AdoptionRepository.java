    package com.animal.shelter.persistence.repository;

    import com.animal.shelter.persistence.entity.AdoptionEntity;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.util.List;

    public interface AdoptionRepository extends JpaRepository<AdoptionEntity,Integer> {
        @Query(value = "SELECT * FROM adoptions a WHERE a.user_name = :username", nativeQuery = true)
        List<AdoptionEntity> findAnimalsByUser(@Param("username") String username);


    }
