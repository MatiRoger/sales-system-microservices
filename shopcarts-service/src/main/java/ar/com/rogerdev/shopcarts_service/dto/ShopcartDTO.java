package ar.com.rogerdev.shopcarts_service.dto;

import ar.com.rogerdev.shopcarts_service.model.Shopcart;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ShopcartDTO (
        @NotNull
        Long user_id,
        Long shopcart_id,
        List<ProductDTO> products_list,
        Double total_price
){
        public ShopcartDTO(Shopcart newShopcart) {
                this(
                        newShopcart.getUser_id(),
                        newShopcart.getShopcart_id(),
                        newShopcart.getProducts_list(),
                        newShopcart.getTotal_price()

                );
        }
}
