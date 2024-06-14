package ar.com.rogerdev.sales_service.service;

import ar.com.rogerdev.sales_service.dto.SaleDTO;
import ar.com.rogerdev.sales_service.dto.ShopcartDTO;
import ar.com.rogerdev.sales_service.model.Sale;
import ar.com.rogerdev.sales_service.repository.ISaleRepository;
import ar.com.rogerdev.sales_service.repository.IShopcartAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepo;
    @Autowired
    private IShopcartAPI shopcartAPI;

    public Sale createSale(SaleDTO newSaleData) {
        return saleRepo.save(new Sale(newSaleData));
    }

    public Page<Sale> getSales(Pageable pagination) {
        return saleRepo.findAll(pagination);
    }

    public ShopcartDTO getSaleTotal(Long shopcartId) {
        Sale sale = saleRepo.getReferenceById(shopcartId);
        return shopcartAPI.findShopcartById(sale.getShopcart_id());
    }

    public void deleteSale(Long saleId) {
        saleRepo.deleteById(saleId);
    }
}
