package dev.javiervs.subtraction.service;

import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.SubtractionRequest;

import java.math.BigDecimal;

public interface SubtractionService {

    /**
     * Subtracts two operands and returns the result.
     *
     * @param request the request containing the two operands
     * @return the result of the subtraction
     * @throws OperandException if either operand is null
     */
    BigDecimal subtract(SubtractionRequest request) throws OperandException;
}
