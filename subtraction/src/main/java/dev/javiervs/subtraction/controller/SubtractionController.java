package dev.javiervs.subtraction.controller;

import dev.javiervs.common.dto.ResultResponse;
import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.SubtractionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/subtraction")
public class SubtractionController {

    private final SubtractionService subtractionService;

    @Operation(summary = "Subtract two numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Subtraction result",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResultResponse.class))})
    })
    @GetMapping
    public ResultResponse addition(@ModelAttribute SubtractionRequest request) throws OperandException {
        BigDecimal result = subtractionService.subtract(request);
        return new ResultResponse(result);
    }
}
