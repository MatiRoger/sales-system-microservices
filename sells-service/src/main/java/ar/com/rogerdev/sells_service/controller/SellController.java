package ar.com.rogerdev.sells_service.controller;

import ar.com.rogerdev.sells_service.dto.SellDTO;
import ar.com.rogerdev.sells_service.dto.ShopcartDTO;
import ar.com.rogerdev.sells_service.model.Sell;
import ar.com.rogerdev.sells_service.service.SellService;
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
@RequestMapping("/sells")
public class SellController {

    @Autowired
    private SellService sellService;
    @PostMapping
    @Transactional
    public ResponseEntity<SellDTO> createSell (@RequestBody @Valid SellDTO newSellData, UriComponentsBuilder uriComponentsBuilder) {

        Sell newSell = sellService.createSell(newSellData);
        URI url = uriComponentsBuilder.path("/sells/{id}").buildAndExpand(newSell.getSell_id()).toUri();
        return ResponseEntity.created(url).body(new SellDTO(newSell));
    }
    @GetMapping
    public ResponseEntity<Page<SellDTO>> getSells (Pageable pagination) {
        return ResponseEntity.ok().body(sellService.getSells(pagination).map(SellDTO::new));
    }
    @GetMapping("/total/{sellId}")
    public ResponseEntity<ShopcartDTO> getSellTotal (@PathVariable Long sellId) {
        return ResponseEntity.ok().body(sellService.getSellTotal(sellId));
    }
    @DeleteMapping("/{sellId}")
    @Transactional
    public ResponseEntity deletSell (@PathVariable Long sellId) {
        sellService.deleteSell(sellId);
        return ResponseEntity.noContent().build();
    }


}
