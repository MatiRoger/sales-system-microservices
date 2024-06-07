package ar.com.rogerdev.shopcarts_service.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("products-service")
public interface IProductAPI {
}
