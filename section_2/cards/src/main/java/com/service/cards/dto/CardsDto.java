package com.service.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        description = "Schema to hold Card details"
)
public class CardsDto {

    @Schema(description = "Card Number of EazyBank card", example = "123456789123")
    @NotEmpty(message = "CardNumber can not be a null or empty")
    private String cardNumber;

    @Schema(description = "Card Type of EazyBank card", example = "Credit Card", allowableValues = {"Credit Card", "Debit Card"})
    @NotEmpty(message = "CardType can not be a null or empty")
    private String cardType;

    @Schema(description = "Total limit of EazyBank card", example = "100000")
    @Positive(message = "Total limit should be greater than zero")
    private int totalLimit;

    @Schema(description = "Amount used by the customer from the EazyBank card", example = "1000")
    @PositiveOrZero(message = "Amount used should be equal or greater than zero")
    private int amountUsed;

    @Schema(description = "Available amount on the EazyBank card", example = "99000")
    @PositiveOrZero(message = "Available amount should be equal or greater than zero")
    private int availableAmount;
}
