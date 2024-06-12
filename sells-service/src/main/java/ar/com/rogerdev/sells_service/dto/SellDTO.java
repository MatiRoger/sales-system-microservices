package ar.com.rogerdev.sells_service.dto;

import ar.com.rogerdev.sells_service.model.Sell;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record SellDTO (
        @NotNull
        Long shopcart_id,
        Long sell_id,
        @DateTimeFormat
        @NotNull
        LocalDate date
) {

    public SellDTO (Sell sell) {
        this(
                sell.getShopcart_id(),
                sell.getSell_id(),
                sell.getDate()
        );
    }
}
