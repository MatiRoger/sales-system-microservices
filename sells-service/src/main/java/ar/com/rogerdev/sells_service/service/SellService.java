package ar.com.rogerdev.sells_service.service;

import ar.com.rogerdev.sells_service.repository.ISellRepository;
import ar.com.rogerdev.sells_service.repository.IShopcartAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellService implements ISellService{
    @Autowired
    private ISellRepository sellRepo;
    @Autowired
    private IShopcartAPI shopcartAPI;
}
