package dev.javiervs.subtraction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.javiervs.common.advice.ExceptionAdvice;
import dev.javiervs.common.dto.ApiError;
import dev.javiervs.common.dto.ResultResponse;
import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.SubtractionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(SubtractionController.class)
public class SubtractionControllerTest {

    public static final String EXPECTED_OPERANDS_EXCEPTION_MESSAGE = "Operands cannot be null";

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private SubtractionService subtractionService;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        SubtractionController controller = new SubtractionController(subtractionService);
        mockMvc = standaloneSetup(controller)
                .setControllerAdvice(new ExceptionAdvice())
                .build();
    }

    @Test
    public void should_returnResultResponse_whenAllOperandsAreNotNull() throws Exception {
        final ResultResponse resultResponse = new ResultResponse(BigDecimal.valueOf(9));
        final String expectedResponseContent = objectMapper.writeValueAsString(resultResponse);

        when(subtractionService.subtract(any(SubtractionRequest.class)))
                .thenReturn(resultResponse.result());

        mockMvc.perform(
                        get("/api/subtraction")
                                .param("firstOperand", BigDecimal.TEN.toString())
                                .param("secondOperand", BigDecimal.ONE.toString()))
                .andExpect(status().isOk())
                .andExpect(
                        content().string(expectedResponseContent));
    }

    @Test
    public void should_returnBadRequest_whenOneOfTheOperandsIsNull() throws Exception {
        final ApiError apiError =
                new ApiError(BAD_REQUEST.value(), EXPECTED_OPERANDS_EXCEPTION_MESSAGE);
        final String expectedResponseContent =
                objectMapper.writeValueAsString(apiError);

        when(subtractionService.subtract(any(SubtractionRequest.class)))
                .thenThrow(new OperandException(EXPECTED_OPERANDS_EXCEPTION_MESSAGE));

        mockMvc.perform(
                        get("/api/subtraction")
                                .param("firstOperand", BigDecimal.ONE.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(
                        content().string(expectedResponseContent));
    }
}
