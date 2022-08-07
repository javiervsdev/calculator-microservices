package dev.javiervs.subtraction.service;

import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.impl.SubtractionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubtractionServiceTest {

    public static final String EXPECTED_OPERANDS_EXCEPTION_MESSAGE = "Operands cannot be null";

    private SubtractionService underTest;

    @BeforeEach
    void setUp() {
        underTest = new SubtractionServiceImpl();
    }

    @Test
    public void should_returnResult_whenAllOperandsAreNotNull() {
        BigDecimal firstOperand = BigDecimal.TEN;
        BigDecimal secondOperand = BigDecimal.ONE;
        final SubtractionRequest validSubtractionRequest =
                new SubtractionRequest(firstOperand, secondOperand);

        final BigDecimal result = underTest.subtract(validSubtractionRequest);

        assertThat(result)
                .isEqualTo(firstOperand.subtract(secondOperand));
    }

    @Test
    public void should_throwOperandException_whenAllOperandsAreNull() {
        final SubtractionRequest emptyOperands = new SubtractionRequest(null, null);

        OperandException operandException = assertThrows(
                OperandException.class,
                () -> underTest.subtract(emptyOperands));

        final String actualExceptionMessage = operandException.getMessage();
        assertThat(actualExceptionMessage)
                .isEqualTo(EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
    }

    @Test
    public void should_throwOperandException_whenFirstOperandsIsNull() {
        final SubtractionRequest firstOperandNullSubtractionRequest = new SubtractionRequest(null, BigDecimal.ONE);
        OperandException operandException = assertThrows(
                OperandException.class,
                () -> underTest.subtract(firstOperandNullSubtractionRequest));

        final String actualExceptionMessage = operandException.getMessage();
        assertThat(actualExceptionMessage)
                .isEqualTo(EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
    }

    @Test
    public void should_throwOperandException_whenSecondOperandsIsNull() {
        final SubtractionRequest secondOperandNullSubtractionRequest = new SubtractionRequest(BigDecimal.ONE, null);
        OperandException operandException = assertThrows(
                OperandException.class,
                () -> underTest.subtract(secondOperandNullSubtractionRequest));

        final String actualExceptionMessage = operandException.getMessage();
        assertThat(actualExceptionMessage)
                .isEqualTo(EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
    }
}
