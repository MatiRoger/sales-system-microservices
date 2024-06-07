package ar.com.rogerdev.sells_service.repository;

import ar.com.rogerdev.sells_service.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellRepository extends JpaRepository<Sell, Long> {
}
