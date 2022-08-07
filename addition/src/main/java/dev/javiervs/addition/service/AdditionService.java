package dev.javiervs.addition.service;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.common.exception.OperandException;

import java.math.BigDecimal;

public interface AdditionService {

    /**
     * Adds two operands and returns the result.
     *
     * @param request the request containing the two operands
     * @return the result of the addition
     * @throws OperandException if either operand is null
     */
    BigDecimal add(AdditionRequest request) throws OperandException;
}
