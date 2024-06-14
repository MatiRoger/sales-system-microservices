package ar.com.rogerdev.sales_service.dto;

import ar.com.rogerdev.sales_service.model.Sale;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record SaleDTO(
        @NotNull
        Long shopcart_id,
        Long sale_id,
        @DateTimeFormat
        @NotNull
        LocalDate date
) {

    public SaleDTO(Sale sale) {
        this(
                sale.getShopcart_id(),
                sale.getSale_id(),
                sale.getDate()
        );
    }
}
