package ar.com.rogerdev.products_service.dto;

import ar.com.rogerdev.products_service.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO (

        @NotBlank
        String product_code,
        @NotBlank
        String name,
        @NotBlank
        String brand,
        @NotNull
        Double unit_price
){
    public ProductDTO(Product product) {
        this(
                product.getProduct_code(),
                product.getName(),
                product.getBrand(),
                product.getUnit_price()
        );
    }
}
