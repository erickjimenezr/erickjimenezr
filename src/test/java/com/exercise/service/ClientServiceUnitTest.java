package com.exercise.service;

import com.exercise.domain.entity.ClientEntity;
import com.exercise.domain.enums.DocumentTypeEnum;
import com.exercise.domain.mapper.ClientMapper;
import com.exercise.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
class ClientServiceUnitTest {

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;

    @SpyBean
    ClientMapper clientMapper;


    @Test
    void getClientByIdTest() {
        var documentId = 1;
        Mockito.when(clientRepository.findById(documentId))
                .thenReturn(Mono.just(new ClientEntity(documentId, DocumentTypeEnum.CEDULA,
                        "Erick", LocalDate.now())));
        var clientDtoMono = clientService.getClientByDocumentId(documentId);
        StepVerifier.create(clientDtoMono)
                .assertNext(clientDto ->
                        Assertions.assertEquals(documentId, clientDto.getDocumentId()))
                .verifyComplete();
    }
}