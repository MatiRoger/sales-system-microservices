package ar.com.rogerdev.shopcarts_service.repository;

import ar.com.rogerdev.shopcarts_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("products-service")
public interface IProductAPI {
    @GetMapping("/products/{productCode}")
    public ProductDTO findProductByCode(@PathVariable String productCode);
}
