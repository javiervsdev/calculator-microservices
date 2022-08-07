package dev.javiervs.subtraction.dto;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public record SubtractionRequest(
        @NonNull BigDecimal firstOperand,
        @NonNull BigDecimal secondOperand) {
}