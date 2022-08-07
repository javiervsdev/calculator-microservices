package dev.javiervs.subtraction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.javiervs.common.dto.ResultResponse;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(SubtractionController.class)
public class SubtractionControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private SubtractionService subtractionService;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        SubtractionController controller = new SubtractionController(subtractionService);
        mockMvc = standaloneSetup(controller).build();
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
}
