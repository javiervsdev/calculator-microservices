package dev.javiervs.addition.dto;

import dev.javiervs.addition.exception.OperandException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public class Addition implements ArithmeticOperation {

    final private BigDecimal firstOperand;
    final private BigDecimal secondOperand;

    public static Addition create(BigDecimal firstOperand, BigDecimal secondOperand) throws OperandException {
        if (firstOperand == null || secondOperand == null) {
            throw new OperandException("Operands cannot be null");
        }
        return new Addition(firstOperand, secondOperand);
    }

    @Override
    public BigDecimal operate() {
        return firstOperand.add(secondOperand);
    }
}
