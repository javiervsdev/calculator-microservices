package dev.javiervs.addition.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.service.AdditionService;
import dev.javiervs.common.advice.ExceptionAdvice;
import dev.javiervs.common.dto.ApiError;
import dev.javiervs.common.dto.ResultResponse;
import dev.javiervs.common.exception.OperandException;
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

@WebMvcTest(AdditionController.class)
public class AdditionControllerTest {

    public static final String EXPECTED_OPERANDS_EXCEPTION_MESSAGE = "Operands cannot be null";

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private AdditionService additionService;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        AdditionController controller = new AdditionController(additionService);
        mockMvc = standaloneSetup(controller)
                .setControllerAdvice(new ExceptionAdvice())
                .build();
    }

    @Test
    public void should_returnResultResponse_whenAllOperandsAreNotNull() throws Exception {
        final ResultResponse resultResponse = new ResultResponse(BigDecimal.valueOf(11));
        final String expectedResponseContent = objectMapper.writeValueAsString(resultResponse);

        when(additionService.add(any(AdditionRequest.class)))
                .thenReturn(resultResponse.result());

        mockMvc.perform(
                        get("/api/addition")
                                .param("firstOperand", BigDecimal.ONE.toString())
                                .param("secondOperand", BigDecimal.TEN.toString()))
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

        when(additionService.add(any(AdditionRequest.class)))
                .thenThrow(new OperandException(EXPECTED_OPERANDS_EXCEPTION_MESSAGE));

        mockMvc.perform(
                        get("/api/addition")
                                .param("firstOperand", BigDecimal.ONE.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(
                        content().string(expectedResponseContent));
    }
}
