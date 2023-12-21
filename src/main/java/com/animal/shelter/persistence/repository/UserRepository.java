package com.animal.shelter.persistence.repository;

import com.animal.shelter.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {


}
