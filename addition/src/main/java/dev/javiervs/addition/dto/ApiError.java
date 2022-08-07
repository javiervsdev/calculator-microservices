package dev.javiervs.addition.dto;

public record ApiError(
        Integer code,
        String message) {}
