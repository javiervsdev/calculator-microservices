package dev.javiervs.subtraction.service.impl;

import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.Subtraction;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.SubtractionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SubtractionServiceImpl implements SubtractionService {

    @Override
    public BigDecimal subtract(SubtractionRequest request) throws OperandException {
        Subtraction subtraction = Subtraction.create(
                request.firstOperand(),
                request.secondOperand());
        return subtraction.operate();
    }
}
