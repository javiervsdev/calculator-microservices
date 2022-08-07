package dev.javiervs.addition.controller;

import dev.javiervs.addition.dto.AdditionRequest;
import dev.javiervs.addition.dto.ResultResponse;
import dev.javiervs.addition.exception.OperandException;
import dev.javiervs.addition.service.AdditionService;
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

    @GetMapping
    public ResultResponse addition(@ModelAttribute AdditionRequest request) throws OperandException {
        BigDecimal result = additionService.add(request);
        return new ResultResponse(result);
    }
}
