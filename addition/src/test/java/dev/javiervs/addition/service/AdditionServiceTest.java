package dev.javiervs.addition.service;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.service.impl.AdditionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionServiceTest {

    private AdditionService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AdditionServiceImpl();
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
}
