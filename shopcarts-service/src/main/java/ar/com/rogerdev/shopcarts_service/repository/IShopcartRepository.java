package ar.com.rogerdev.shopcarts_service.repository;

import ar.com.rogerdev.shopcarts_service.model.Shopcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopcartRepository extends JpaRepository<Shopcart, Long> {
}
