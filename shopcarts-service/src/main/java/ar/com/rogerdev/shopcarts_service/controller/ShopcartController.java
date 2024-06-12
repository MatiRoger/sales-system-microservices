package ar.com.rogerdev.shopcarts_service.controller;

import ar.com.rogerdev.shopcarts_service.dto.ShopcartDTO;
import ar.com.rogerdev.shopcarts_service.model.Shopcart;
import ar.com.rogerdev.shopcarts_service.repository.IProductAPI;
import ar.com.rogerdev.shopcarts_service.service.ShopcartService;
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
@RequestMapping("/shopcart")
public class ShopcartController {
    @Autowired
    private ShopcartService shopcartService;

    @PostMapping
    @Transactional
    public ResponseEntity<ShopcartDTO> createShopcart (@RequestBody @Valid ShopcartDTO shopcartData, UriComponentsBuilder uriComponentsBuilder) {
        Shopcart newShopcart = shopcartService.createShopcart(shopcartData);
        URI url = uriComponentsBuilder.path("/shopcart/{id}").buildAndExpand(newShopcart.getShopcart_id()).toUri();
        return ResponseEntity.created(url).body(new ShopcartDTO(newShopcart));
    }
    @GetMapping
    public ResponseEntity<Page<ShopcartDTO>> getShopcarts (Pageable pagination) {
        return ResponseEntity.ok().body(shopcartService.getShopcarts(pagination).map(ShopcartDTO::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ShopcartDTO> findShopcartById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ShopcartDTO(shopcartService.findShopcart(id)));
    }
    @PatchMapping("/{id}/{productCode}")
    @Transactional
    public ResponseEntity<ShopcartDTO> addProduct (@PathVariable Long id, @PathVariable String productCode) {
        return ResponseEntity.ok().body(new ShopcartDTO(shopcartService.addProductToCart(id,productCode)));
    }
    @PatchMapping("/{id}/rm-product/{productCode}")
    @Transactional
    public ResponseEntity<ShopcartDTO> removeProduct (@PathVariable Long id, @PathVariable String productCode) {
        return ResponseEntity.ok().body(new ShopcartDTO(shopcartService.removeProduct(id, productCode)));
    }
}
