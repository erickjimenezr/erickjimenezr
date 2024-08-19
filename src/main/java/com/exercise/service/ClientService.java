package com.exercise.service;

import com.exercise.domain.mapper.ClientMapper;
import com.exercise.domain.model.ClientDto;
import com.exercise.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Mono<ClientDto> getClientByDocumentId(Integer documentId){
        return clientRepository.findById(documentId)
                .map(clientMapper::toDto);
    }

    public Mono<ClientDto> saveClient(ClientDto clientDto){
        return clientRepository.save(clientMapper.toEntity(clientDto))
                .map(clientMapper::toDto);
    }
}
