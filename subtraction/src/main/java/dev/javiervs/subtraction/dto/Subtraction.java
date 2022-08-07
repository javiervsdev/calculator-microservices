package dev.javiervs.subtraction.dto;

import dev.javiervs.common.dto.ArithmeticOperation;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class Subtraction implements ArithmeticOperation {

    final private BigDecimal firstOperand;
    final private BigDecimal secondOperand;

    @Override
    public BigDecimal operate() {
        return firstOperand.subtract(secondOperand);
    }
}
