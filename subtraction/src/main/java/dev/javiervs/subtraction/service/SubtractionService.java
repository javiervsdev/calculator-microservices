package dev.javiervs.subtraction.service;

import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.SubtractionRequest;

import java.math.BigDecimal;

public interface SubtractionService {
    BigDecimal subtract(SubtractionRequest request) throws OperandException;
}
