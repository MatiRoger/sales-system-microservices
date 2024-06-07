package ar.com.rogerdev.shopcarts_service.service;

import ar.com.rogerdev.shopcarts_service.repository.IProductAPI;
import ar.com.rogerdev.shopcarts_service.repository.IShopcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopcartService implements IShopcartService {
    @Autowired
    private IShopcartRepository shopcartRepo;
    @Autowired
    private IProductAPI productAPI;
}
