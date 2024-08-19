package com.exercise.domain.entity;

import com.exercise.domain.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ClientEntity {

    @Id
    private Integer documentId;
    private DocumentTypeEnum documentType;
    private String fullName;
    private LocalDate birthdate;
}
