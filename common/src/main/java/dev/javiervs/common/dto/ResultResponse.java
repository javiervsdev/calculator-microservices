package dev.javiervs.common.dto;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public record ResultResponse(@NonNull BigDecimal result) {}
