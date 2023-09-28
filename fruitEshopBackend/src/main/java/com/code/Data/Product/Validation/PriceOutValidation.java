package com.code.Data.Product.Validation;

import com.code.Data.Product.Product;
import com.code.Data.Product.ProductBase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

public @interface PriceOutValidation {
    String message() default "Price out must be bigger than Price in";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class PriceOutValidator implements ConstraintValidator<PriceOutValidation, ProductBase> {

    @Override
    public boolean isValid(ProductBase product, ConstraintValidatorContext constraintValidatorContext) {
        return product.getPriceOut() > product.getPriceIn();
    }
}