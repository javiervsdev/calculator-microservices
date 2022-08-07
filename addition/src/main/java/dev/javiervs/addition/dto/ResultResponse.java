package dev.javiervs.addition.dto;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public record ResultResponse(@NonNull BigDecimal result) {}
