package dev.javiervs.subtraction.service;

import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.impl.SubtractionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionServiceTest {

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
}
