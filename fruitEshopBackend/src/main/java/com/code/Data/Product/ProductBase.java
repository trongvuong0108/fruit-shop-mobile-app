package com.code.Data.Product;

import com.code.Data.Product.DTO.CreateOrUpdateProductRequest;
import com.code.Data.Product.Validation.PriceOutValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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
