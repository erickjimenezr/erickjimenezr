package com.exercise.repository;

import com.exercise.domain.entity.ClientEntity;
import com.exercise.domain.enums.DocumentTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test")
class ClientRepositoryIntTest {

    @Autowired
    ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        var clientEntities = List.of(new ClientEntity(100, DocumentTypeEnum.CEDULA,
                        "Erick Jimenez", LocalDate.now()));
        clientRepository.saveAll(clientEntities).blockLast();
    }

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll().block();
    }

    @Test
    void findByIdTest() {
        var clientEntityMono = clientRepository.findById(100).log();

        StepVerifier.create(clientEntityMono)
                .assertNext(clientEntity ->
                        assertEquals("Erick Jimenez", clientEntity.getFullName()))
                .verifyComplete();
    }
}