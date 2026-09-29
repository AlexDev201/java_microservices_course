package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Schema(
        description = "Schema to hold response status information"
)
public class ResponseDto {
    @Schema(description = "Status code of the operation", example = "200")
    private String statusCode;
    @Schema(description = "Status message of the operation", example = "Request processed successfully")
    private String statusMessage;
}
