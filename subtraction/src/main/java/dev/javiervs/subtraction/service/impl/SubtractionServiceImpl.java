package dev.javiervs.subtraction.service.impl;

import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.Subtraction;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.SubtractionService;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SubtractionServiceImpl implements SubtractionService {

    private final TracerImpl tracer;

    @Override
    public BigDecimal subtract(SubtractionRequest request) throws OperandException {
        Subtraction subtraction = Subtraction.create(
                request.firstOperand(),
                request.secondOperand());
        BigDecimal result = subtraction.operate();
        tracer.trace(result.toString());
        return result;
    }
}
