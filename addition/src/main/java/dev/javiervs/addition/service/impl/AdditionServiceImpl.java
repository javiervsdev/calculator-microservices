package dev.javiervs.addition.service.impl;

import dev.javiervs.addition.dto.Addition;
import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.exception.OperandException;
import dev.javiervs.addition.service.AdditionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AdditionServiceImpl implements AdditionService {

    @Override
    public BigDecimal add(AdditionRequest request) throws OperandException {
        Addition addition = Addition.create(
                request.firstOperand(),
                request.secondOperand());
        return addition.operate();
    }
}
