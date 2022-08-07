package dev.javiervs.addition.dto;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class Addition implements ArithmeticOperation {

    final private BigDecimal firstOperand;
    final private BigDecimal secondOperand;

    @Override
    public BigDecimal operate() {
        return firstOperand.add(secondOperand);
    }
}
