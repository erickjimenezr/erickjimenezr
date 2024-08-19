package com.exercise.repository;

import com.exercise.domain.entity.ClientEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<ClientEntity, Integer> {
}
