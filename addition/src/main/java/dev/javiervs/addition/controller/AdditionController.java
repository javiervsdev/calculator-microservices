package dev.javiervs.addition.controller;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.dto.ResultResponse;
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

    @GetMapping
    public ResultResponse addition(@ModelAttribute AdditionRequest request) {
        BigDecimal result = request.firstOperand().add(request.secondOperand());
        return new ResultResponse(result);
    }
}