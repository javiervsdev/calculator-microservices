package dev.javiervs.addition.service;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.service.impl.AdditionServiceImpl;
import dev.javiervs.common.exception.OperandException;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class AdditionServiceTest {

    public static final String EXPECTED_OPERANDS_EXCEPTION_MESSAGE = "Operands cannot be null";

    private AdditionService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AdditionServiceImpl(mock(TracerImpl.class));
    }

    @Test
    public void should_returnResult_whenAllOperandsAreNotNull() {
        BigDecimal firstOperand = BigDecimal.ONE;
        BigDecimal secondOperand = BigDecimal.ONE;
        final AdditionRequest validAdditionRequest =
                new AdditionRequest(firstOperand, secondOperand);

        final BigDecimal result = underTest.add(validAdditionRequest);

        assertThat(result)
                .isEqualTo(firstOperand.add(secondOperand));
    }

    @Test
    public void should_throwOperandException_whenAllOperandsAreNull() {
        final AdditionRequest emptyOperands = new AdditionRequest(null, null);

        OperandException operandException = assertThrows(
                OperandException.class,
                () -> underTest.add(emptyOperands));

        final String actualExceptionMessage = operandException.getMessage();
        assertThat(actualExceptionMessage)
                .isEqualTo(EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
    }

    @Test
    public void should_throwOperandException_whenFirstOperandsIsNull() {
        final AdditionRequest firstOperandNullAdditionRequest = new AdditionRequest(null, BigDecimal.ONE);
        OperandException operandException = assertThrows(
                OperandException.class,
                () -> underTest.add(firstOperandNullAdditionRequest));

        final String actualExceptionMessage = operandException.getMessage();
        assertThat(actualExceptionMessage)
                .isEqualTo(EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
    }

    @Test
    public void should_throwOperandException_whenSecondOperandsIsNull() {
        final AdditionRequest secondOperandNullAdditionRequest = new AdditionRequest(BigDecimal.ONE, null);
        OperandException operandException = assertThrows(
                OperandException.class,
                () -> underTest.add(secondOperandNullAdditionRequest));

        final String actualExceptionMessage = operandException.getMessage();
        assertThat(actualExceptionMessage)
                .isEqualTo(EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
    }
}
