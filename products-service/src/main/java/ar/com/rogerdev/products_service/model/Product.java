package ar.com.rogerdev.products_service.model;

import ar.com.rogerdev.products_service.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private String product_code;
    private String name;
    private String brand;
    private Double unit_price;

    public Product (ProductDTO newProduct) {
        this.product_code = newProduct.product_code();
        this.name = newProduct.name();
        this.brand = newProduct.brand();
        this.unit_price = newProduct.unit_price();
    }

}