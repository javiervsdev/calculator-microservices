package dev.javiervs.addition.service.impl;

import dev.javiervs.addition.dto.Addition;
import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.exception.OperandException;
import dev.javiervs.addition.service.AdditionService;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AdditionServiceImpl implements AdditionService {

    private final TracerImpl tracer;

    @Override
    public BigDecimal add(AdditionRequest request) throws OperandException {
        Addition addition = Addition.create(
                request.firstOperand(),
                request.secondOperand());
        BigDecimal result = addition.operate();
        tracer.trace(result.toString());
        return result;
    }
}
