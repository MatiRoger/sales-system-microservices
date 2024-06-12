package ar.com.rogerdev.shopcarts_service.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductDTO (
        String name,
        Double unit_price
){
}
