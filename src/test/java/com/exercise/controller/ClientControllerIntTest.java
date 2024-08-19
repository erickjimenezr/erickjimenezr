package com.exercise.controller;

import com.exercise.domain.model.ClientDto;
import com.exercise.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class ClientControllerIntTest {


    @Autowired
    WebTestClient webTestClient;

    @Autowired
    ClientRepository clientRepository;

    static final String CLIENT_URL = "/v1/client";

    @Test
    void saveClient() {
        //given
        var documentId = 1;
        var clientDto = new ClientDto(documentId, "CEDULA", "Erick", LocalDate.now());

        //when
        webTestClient.post()
                .uri(CLIENT_URL)
                .bodyValue(clientDto)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(ClientDto.class)
                .consumeWith(clientDtoEntityExchangeResult -> {
                    var savedClientDto = clientDtoEntityExchangeResult.getResponseBody();
                    assert savedClientDto != null;
                    assert savedClientDto.getDocumentId() != null;
                    assertEquals(documentId, savedClientDto.getDocumentId());
                });
    }

}