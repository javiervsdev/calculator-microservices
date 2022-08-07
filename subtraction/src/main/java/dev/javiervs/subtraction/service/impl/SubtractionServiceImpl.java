package dev.javiervs.subtraction.service.impl;

import dev.javiervs.subtraction.dto.Subtraction;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.SubtractionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SubtractionServiceImpl implements SubtractionService {

    @Override
    public BigDecimal subtract(SubtractionRequest request) {
        Subtraction subtraction = new Subtraction(
                request.firstOperand(),
                request.secondOperand());
        return subtraction.operate();
    }
}
