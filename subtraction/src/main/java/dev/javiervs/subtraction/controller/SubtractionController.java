package dev.javiervs.subtraction.controller;

import dev.javiervs.common.dto.ResultResponse;
import dev.javiervs.subtraction.dto.SubtractionRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/subtraction")
public class SubtractionController {

    @GetMapping
    public ResultResponse addition(@ModelAttribute SubtractionRequest request) {
        BigDecimal result = request.firstOperand().subtract(request.secondOperand());
        return new ResultResponse(result);
    }
}
