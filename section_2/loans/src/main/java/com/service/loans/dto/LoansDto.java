package com.service.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        description = "Schema to hold Loan details"
)
public class LoansDto {

    @Schema(description = "Loan Number of EazyBank loan", example = "123456789123")
    @NotEmpty(message = "LoanNumber can not be a null or empty")
    private String loanNumber;

    @Schema(description = "Loan Type of EazyBank loan", example = "Home Loan", allowableValues = {"Home Loan", "Personal Loan", "Vehicle Loan"})
    @NotEmpty(message = "LoanType can not be a null or empty")
    private String loanType;

    @Schema(description = "Total amount of the loan", example = "100000")
    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @Schema(description = "Amount already paid by the customer", example = "10000")
    @PositiveOrZero(message = "Amount paid should be equal or greater than zero")
    private int amountPaid;

    @Schema(description = "Outstanding amount of the loan", example = "90000")
    @PositiveOrZero(message = "Outstanding amount should be equal or greater than zero")
    private int outstandingAmount;
}
