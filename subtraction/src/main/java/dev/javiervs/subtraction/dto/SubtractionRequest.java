package dev.javiervs.subtraction.dto;

import java.math.BigDecimal;

public record SubtractionRequest(
        BigDecimal firstOperand,
        BigDecimal secondOperand) {
}