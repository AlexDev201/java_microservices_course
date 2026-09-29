package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {
    @Schema(description = "API path where the error occurred", example = "/api/create")
    private String apiPath;
    @Schema(description = "HTTP status code of the error", example = "INTERNAL_SERVER_ERROR")
    private HttpStatus errorCode;
    @Schema(description = "Error message describing the failure", example = "An unexpected error occurred")
    private String errorMessage;
    @Schema(description = "Date and time when the error occurred", example = "2026-09-28T10:15:30")
    private LocalDateTime errorTime;
}