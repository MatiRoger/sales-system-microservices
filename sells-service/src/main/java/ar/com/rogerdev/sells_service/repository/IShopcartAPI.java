package ar.com.rogerdev.sells_service.repository;

import ar.com.rogerdev.sells_service.dto.ShopcartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shopcarts-service")
public interface IShopcartAPI {

    @GetMapping("/shopcart/{id}")
    public ShopcartDTO findShopcartById (@PathVariable Long id);
}
