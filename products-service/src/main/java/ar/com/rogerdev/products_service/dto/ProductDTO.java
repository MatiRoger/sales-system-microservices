package ar.com.rogerdev.products_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String product_code;
    private String name;
    private String brand;
    private Double unit_price;
}
