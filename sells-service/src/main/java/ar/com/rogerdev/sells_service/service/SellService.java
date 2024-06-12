package ar.com.rogerdev.sells_service.service;

import ar.com.rogerdev.sells_service.dto.SellDTO;
import ar.com.rogerdev.sells_service.dto.ShopcartDTO;
import ar.com.rogerdev.sells_service.model.Sell;
import ar.com.rogerdev.sells_service.repository.ISellRepository;
import ar.com.rogerdev.sells_service.repository.IShopcartAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellService implements ISellService{
    @Autowired
    private ISellRepository sellRepo;
    @Autowired
    private IShopcartAPI shopcartAPI;

    public Sell createSell(SellDTO newSellData) {
        return sellRepo.save(new Sell(newSellData));
    }

    public Page<Sell> getSells(Pageable pagination) {
        return sellRepo.findAll(pagination);
    }

    public ShopcartDTO getSellTotal(Long shopcartId) {
        Sell sell = sellRepo.getReferenceById(shopcartId);
        return shopcartAPI.findShopcartById(sell.getShopcart_id());
    }

    public void deleteSell(Long sellId) {
        sellRepo.deleteById(sellId);
    }
}
