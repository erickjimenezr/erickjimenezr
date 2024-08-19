package com.exercise.infrastructurevalidators;

import com.exercise.infrastructure.annotations.MatchEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchEnumValidator implements ConstraintValidator<MatchEnum, String> {

    private Set<String> acceptedValues;

    @Override
    public void initialize(MatchEnum annotation) {
        this.acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toUpperCase());
    }
}
