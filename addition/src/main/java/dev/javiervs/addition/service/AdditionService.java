package dev.javiervs.addition.service;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.exception.OperandException;

import java.math.BigDecimal;

public interface AdditionService {
    BigDecimal add(AdditionRequest request) throws OperandException;
}
