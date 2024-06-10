package ar.com.rogerdev.products_service.service;

import ar.com.rogerdev.products_service.dto.ProductDTO;
import ar.com.rogerdev.products_service.model.Product;
import ar.com.rogerdev.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepo;

    public Product saveProduct (ProductDTO newProductData) {
        Product newProduct = new Product(newProductData);
        return productRepo.save(newProduct);
    }
    public Page<Product> getProducts(Pageable pagination) {
        return productRepo.findAll(pagination);
    }
    public Product findProductByCode (String productCode){
        return productRepo.getReferenceById(productCode);
    }

    public void deleteProductByCode(String productCode) {
        productRepo.deleteById(productCode);
    }
}
