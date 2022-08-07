package dev.javiervs.addition.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.javiervs.addition.dto.ResultResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(AdditionController.class)
public class AdditionControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        AdditionController controller = new AdditionController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void should_returnResultResponse_whenAllOperandsAreNotNull() throws Exception {
        final ResultResponse resultResponse = new ResultResponse(BigDecimal.valueOf(11));
        final String expectedResponseContent = objectMapper.writeValueAsString(resultResponse);

        mockMvc.perform(
                        get("/api/addition")
                                .param("firstOperand", BigDecimal.ONE.toString())
                                .param("secondOperand", BigDecimal.TEN.toString()))
                .andExpect(status().isOk())
                .andExpect(
                        content().string(expectedResponseContent));
    }
}
