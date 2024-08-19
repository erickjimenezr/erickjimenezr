package com.exercise.domain.mapper;

import com.exercise.domain.entity.ClientEntity;
import com.exercise.domain.model.ClientDto;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    ClientEntity toEntity(ClientDto dto);
    ClientDto toDto(ClientEntity entity);
}
