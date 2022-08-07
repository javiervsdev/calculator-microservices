package dev.javiervs.subtraction.dto;

import dev.javiervs.common.dto.ArithmeticOperation;
import dev.javiervs.common.exception.OperandException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public class Subtraction implements ArithmeticOperation {

    final private BigDecimal firstOperand;
    final private BigDecimal secondOperand;

    public static Subtraction create(BigDecimal firstOperand, BigDecimal secondOperand) throws OperandException {
        if (firstOperand == null || secondOperand == null) {
            throw new OperandException("Operands cannot be null");
        }
        return new Subtraction(firstOperand, secondOperand);
    }

    @Override
    public BigDecimal operate() {
        return firstOperand.subtract(secondOperand);
    }
}
