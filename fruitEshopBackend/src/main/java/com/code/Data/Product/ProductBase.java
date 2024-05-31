package com.code.Data.Product;

import com.code.Data.Product.DTO.CreateOrUpdateProductRequest;
import com.code.Data.Product.Validation.PriceOutValidation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBase {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name ;
    @NotNull
    @NotEmpty
    @NotBlank
    private float quantity;
    @NotNull
    @NotEmpty
    @NotBlank
    @Min(0)
    private float priceIn;
    @PriceOutValidation
    private float priceOut;

    public ProductBase(CreateOrUpdateProductRequest request) {
        this.name = request.getName();
        this.quantity = request.getQuantity();
        this.priceIn = request.getPriceIn();
        this.priceOut = request.getPriceOut();
    }
}
