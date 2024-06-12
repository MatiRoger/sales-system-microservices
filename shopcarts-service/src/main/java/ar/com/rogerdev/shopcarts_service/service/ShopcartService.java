package ar.com.rogerdev.shopcarts_service.service;

import ar.com.rogerdev.shopcarts_service.dto.ProductDTO;
import ar.com.rogerdev.shopcarts_service.dto.ShopcartDTO;
import ar.com.rogerdev.shopcarts_service.model.Shopcart;
import ar.com.rogerdev.shopcarts_service.repository.IProductAPI;
import ar.com.rogerdev.shopcarts_service.repository.IShopcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShopcartService implements IShopcartService {
    @Autowired
    private IShopcartRepository shopcartRepo;
    @Autowired
    private IProductAPI productAPI;

    public Shopcart createShopcart(ShopcartDTO shopcartData) {
        Shopcart newShopcart = new Shopcart(shopcartData);
        return shopcartRepo.save(newShopcart);
    }

    public Page<Shopcart> getShopcarts(Pageable pagination) {
        return shopcartRepo.findAll(pagination);
    }
    public Shopcart addProductToCart(Long shopcartId, String productCode) {
        Shopcart shopcart = shopcartRepo.getReferenceById(shopcartId);
        ProductDTO product = productAPI.findProductByCode(productCode);
        shopcart.getProducts_list().add(product);
        shopcart.updateTotalPrice();
        return shopcartRepo.save(shopcart);
    }

    public Shopcart findShopcart(Long id) {
        return shopcartRepo.getReferenceById(id);
    }

    public Shopcart removeProduct(Long id, String productCode) {
        Shopcart shopcart = shopcartRepo.getReferenceById(id);
        ProductDTO product = productAPI.findProductByCode(productCode);
        shopcart.getProducts_list().remove(product);
        shopcart.updateTotalPrice();
        return shopcartRepo.save(shopcart);
    }
}
