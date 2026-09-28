package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AccountsDto {
    @NotNull(message = "AccountNumber can not be null")
    @Positive(message = "AccountNumber must be a positive number")
    @Digits(integer = 10, fraction = 0, message = "AccountNumber must be a 10 digit number")
    private Long accountNumber;
    @NotEmpty(message = "AccountType can not be a null or empty")
    private  String accountType;
    @NotEmpty(message = "branchAddress can not be null or empty")
    private String branchAddress;
}
