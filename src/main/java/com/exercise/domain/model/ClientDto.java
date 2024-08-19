package com.exercise.domain.model;

import com.exercise.domain.enums.DocumentTypeEnum;
import com.exercise.infrastructure.annotations.MatchEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    @NotNull(message = "Invalid document....")
    @Min(value = 0, message = "Invalid document")
    @Max(value = 999999999, message = "Invalid document")
    private Integer documentId;

    @NotNull
    @MatchEnum(enumClass = DocumentTypeEnum.class, message = "Invalid document type")
    private String documentType;

    @NotEmpty(message = "Invalid full name")
    private String fullName;
    private LocalDate birthdate;
}
