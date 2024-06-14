package ar.com.rogerdev.sales_service.controller;

import ar.com.rogerdev.sales_service.dto.SaleDTO;
import ar.com.rogerdev.sales_service.dto.ShopcartDTO;
import ar.com.rogerdev.sales_service.model.Sale;
import ar.com.rogerdev.sales_service.service.SaleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @PostMapping
    @Transactional
    public ResponseEntity<SaleDTO> createSale (@RequestBody @Valid SaleDTO newSaleData, UriComponentsBuilder uriComponentsBuilder) {

        Sale newSale = saleService.createSale(newSaleData);
        URI url = uriComponentsBuilder.path("/sales/{id}").buildAndExpand(newSale.getSale_id()).toUri();
        return ResponseEntity.created(url).body(new SaleDTO(newSale));
    }
    @GetMapping
    public ResponseEntity<Page<SaleDTO>> getSales(Pageable pagination) {
        return ResponseEntity.ok().body(saleService.getSales(pagination).map(SaleDTO::new));
    }
    @GetMapping("/total/{saleId}")
    public ResponseEntity<ShopcartDTO> getSaleTotal(@PathVariable Long saleId) {
        return ResponseEntity.ok().body(saleService.getSaleTotal(saleId));
    }
    @DeleteMapping("/{saleId}")
    @Transactional
    public ResponseEntity deletSale (@PathVariable Long saleId) {
        saleService.deleteSale(saleId);
        return ResponseEntity.noContent().build();
    }


}
