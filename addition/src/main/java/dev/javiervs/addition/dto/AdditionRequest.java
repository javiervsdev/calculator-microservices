package dev.javiervs.addition.dto;

import java.math.BigDecimal;

public record AdditionRequest(
        BigDecimal firstOperand,
        BigDecimal secondOperand) {
}
