package ar.com.rogerdev.products_service.service;

import ar.com.rogerdev.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepo;
}
