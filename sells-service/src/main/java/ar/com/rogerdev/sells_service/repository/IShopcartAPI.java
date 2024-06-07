package ar.com.rogerdev.sells_service.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("shopcarts-service")
public interface IShopcartAPI {
}
