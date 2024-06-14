package ar.com.rogerdev.sales_service.model;

import ar.com.rogerdev.sales_service.dto.SaleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sale_id;
    private Long shopcart_id;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    public Sale(SaleDTO newSaleData) {
        this.shopcart_id = newSaleData.shopcart_id();
        this.date = newSaleData.date();

    }
}
