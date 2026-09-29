package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(
        description = "Schema to hold Account details"
)
public class AccountsDto {
    @Schema(description = "Account Number of EazyBank account", example = "1234567890")
    @NotNull(message = "AccountNumber can not be null")
    @Positive(message = "AccountNumber must be a positive number")
    @Digits(integer = 10, fraction = 0, message = "AccountNumber must be a 10 digit number")
    private Long accountNumber;
    @Schema(description = "Account Type of EazyBank account", example = "Savings", allowableValues = {"Savings", "Current"})
    @NotEmpty(message = "AccountType can not be a null or empty")
    private  String accountType;
    @Schema(description = "EazyBank branch address of the account", example = "123 Main Street, New York")
    @NotEmpty(message = "branchAddress can not be null or empty")
    private String branchAddress;
}
