package dev.javiervs.addition.dto;

import org.springframework.lang.NonNull;

public record ApiError(
        @NonNull Integer code,
        String message) {}
