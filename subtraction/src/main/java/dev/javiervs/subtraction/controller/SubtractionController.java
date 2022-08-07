package dev.javiervs.subtraction.controller;

import dev.javiervs.common.dto.ResultResponse;
import dev.javiervs.common.exception.OperandException;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import dev.javiervs.subtraction.service.SubtractionService;
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

    @GetMapping
    public ResultResponse addition(@ModelAttribute SubtractionRequest request) throws OperandException {
        BigDecimal result = subtractionService.subtract(request);
        return new ResultResponse(result);
    }
}
