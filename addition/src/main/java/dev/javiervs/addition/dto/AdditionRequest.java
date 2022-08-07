package dev.javiervs.addition.dto;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public record AdditionRequest(
        @NonNull BigDecimal firstOperand,
        @NonNull BigDecimal secondOperand) {
}
