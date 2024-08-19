package com.exercise.controller;

import com.exercise.domain.model.ClientDto;
import com.exercise.service.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
@Validated
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client/{documentId}")
    public Mono<ResponseEntity<ClientDto>> getClientByDocumentId(@NotNull @PathVariable Integer documentId){
        return clientService.getClientByDocumentId(documentId)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping("/client")
    public Mono<ResponseEntity<ClientDto>> saveClient(@Valid @RequestBody ClientDto clientDto){
        log.info("Aqui");
        return clientService.saveClient(clientDto)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client));
    }
}
