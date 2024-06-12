package ar.com.rogerdev.sells_service.model;

import ar.com.rogerdev.sells_service.dto.SellDTO;
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
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sell_id;
    private Long shopcart_id;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    public Sell(SellDTO newSellData) {
        this.shopcart_id = newSellData.shopcart_id();
        this.date = newSellData.date();

    }
}
