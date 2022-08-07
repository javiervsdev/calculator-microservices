package dev.javiervs.addition.controller;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.dto.ResultResponse;
import dev.javiervs.addition.exception.OperandException;
import dev.javiervs.addition.service.AdditionService;
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
@RequestMapping("api/addition")
public class AdditionController {

    private final AdditionService additionService;

    @Operation(summary = "Add two numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Addition result",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResultResponse.class))})
    })
    @GetMapping
    public ResultResponse addition(@ModelAttribute AdditionRequest request) throws OperandException {
        BigDecimal result = additionService.add(request);
        return new ResultResponse(result);
    }
}
