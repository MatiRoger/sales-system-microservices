package ar.com.rogerdev.shopcarts_service.model;

import ar.com.rogerdev.shopcarts_service.dto.ProductDTO;
import ar.com.rogerdev.shopcarts_service.dto.ShopcartDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shopcart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopcart_id;
    private Long user_id;
    @ElementCollection
    private List<ProductDTO> products_list = new ArrayList<>();
    private Double total_price;

    public Shopcart (ShopcartDTO data) {
        this.user_id = data.user_id();
        this.products_list = new ArrayList<>();
        this.total_price = 0.0;
    }
    public void updateTotalPrice () {
        this.total_price = this.products_list.stream().mapToDouble(ProductDTO::unit_price).sum();
    }
}

